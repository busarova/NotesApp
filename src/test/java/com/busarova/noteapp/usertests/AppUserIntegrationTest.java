package com.busarova.noteapp.usertests;

import com.busarova.noteapp.TestUtil;
import com.busarova.noteapp.authentication.ApplicationUserDetailsService;
import com.busarova.noteapp.user.model.AppUser;
import com.busarova.noteapp.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles({"test"})
public class AppUserIntegrationTest {
  
  
  @Autowired
  private UserRepository repository;
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  // Tests repository
  @Test public void testStoreUser() {
    AppUser user = TestUtil.createTestUser();
    repository.save(user);
    assertThat(user).isNotNull();
    assertThat(repository.count()).isEqualTo(1L);
  }
  
  @Test
  public void testFindByEmail() {
    AppUser appUser = TestUtil.createTestUser();
    repository.save(appUser);
    Optional<AppUser> optional = repository.findByEmail(appUser.getEmail());
    assertThat(optional).isNotEmpty()
        .contains(appUser);
  }
  @Test
  public void testFindByEmail_unknownEmail() {
    AppUser appUser = TestUtil.createTestUser();
    repository.save(appUser);
    Optional<AppUser> optional = repository.findByEmail("unknown@tests.com");
    assertThat(optional).isEmpty();
  }
  
  // Tests security
  @Test
  public void givenExistingUsername_whenLoadingUser_userIsReturned() {
    AppUser user = TestUtil.createTestUser();
    repository.save(user);
    ApplicationUserDetailsService service = new ApplicationUserDetailsService(repository);
    UserDetails userDetails = service.loadUserByUsername(TestUtil.TEST_EMAIL);
    assertThat(userDetails).isNotNull();
    assertThat(userDetails.getUsername()).isEqualTo(TestUtil.TEST_EMAIL);
    assertThat(userDetails.getAuthorities()).extracting(GrantedAuthority::getAuthority).contains("ROLE_CUSTOMER");
  }
  
  @Test(expected = UsernameNotFoundException.class)
  public void givenNotExistingUsername_whenLoadingUser_exceptionThrown() {
    AppUser user = TestUtil.createTestUser();
    repository.save(user);
    ApplicationUserDetailsService service = new ApplicationUserDetailsService(repository);
    service.loadUserByUsername("unknown@tests.com");
  }
  
  @Test
  public void testSaveUser() {
    
    AppUser user = TestUtil.createTestUser();
    repository.save(user);
    assertThat(user).isNotNull();
    assertThat(repository.count()).isEqualTo(1L);
    entityManager.flush();
    assertThat(jdbcTemplate.queryForObject("SELECT count(*) FROM app_user",
        Long.class)).isEqualTo(1L);
    assertThat(jdbcTemplate.queryForObject("SELECT count(*) FROM app_user_roles",
        Long.class)).isEqualTo(1L);
    assertThat(jdbcTemplate.queryForObject("SELECT roles FROM app_user_roles",
        String.class)).isEqualTo("CUSTOMER");
  }
  
}
