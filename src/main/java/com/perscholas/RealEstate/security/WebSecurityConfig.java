package com.perscholas.RealEstate.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests(requests -> requests
                        .mvcMatchers("/login").permitAll()
                        .mvcMatchers("/signup").permitAll()

//                        .mvcMatchers("/").permitAll()              //these are url's/handlers, not html pages
                        .mvcMatchers("/aboutButtonHandler").permitAll()
                        .mvcMatchers("/contactButtonHandler").permitAll()
                        .mvcMatchers("/housesListHandlerCustomer").permitAll()




                        .mvcMatchers("/addNewDepartmentPage").hasAnyRole("SUPERADMIN")
                        .mvcMatchers("/deleteDepartmentPageHandler/**").hasAnyRole("SUPERADMIN")
                        .mvcMatchers("/updateDepartmentPageHandler/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/saveDepartment/**").hasAnyRole("ADMIN", "SUPERADMIN")

                        .mvcMatchers("/addNewCustomerForm").hasAnyRole("SUPERADMIN")
                        .mvcMatchers("/deleteCustomerPage/**").hasAnyRole("SUPERADMIN")
                        .mvcMatchers("/updateCustomerPage/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/saveCustomer/**").hasAnyRole("ADMIN", "SUPERADMIN")

                        .mvcMatchers("/addNewHouseForm").hasAnyRole("SUPERADMIN")
                        .mvcMatchers("/deleteHousePage/**").hasAnyRole("SUPERADMIN")
                        .mvcMatchers("/updateHousePage/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/saveHouse/**").hasAnyRole("ADMIN", "SUPERADMIN")


                        .mvcMatchers("/addNewMaintenanceForm").hasAnyRole("SUPERADMIN")
                        .mvcMatchers("/deleteMaintenancePage/**").hasAnyRole("SUPERADMIN")
                        .mvcMatchers("/updateMaintenancePage/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .mvcMatchers("/saveMaintenance/**").hasAnyRole("ADMIN", "SUPERADMIN")

                        .mvcMatchers("/adminButtonHandler").hasAnyRole("SUPERADMIN")
                        .mvcMatchers("/customerByLastNameHandler/**").hasAnyRole("SUPERADMIN")



                        .mvcMatchers("/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                        .anyRequest().authenticated())


                .formLogin(login -> login
                        .loginPage("/login")        //this starts the login process
                        .defaultSuccessUrl("/")     // this statement controls what is the next page after the login
//                        .defaultSuccessUrl("/home_general")     // this statement controls what is the next page after the login
                        .failureForwardUrl("/")
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/login"));




    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder
                = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()

                .withUser("user")
                .password(passwordEncoder.encode("user"))
                .roles("USER")

                .and()
                .withUser("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("USER", "ADMIN")

                .and()
                .withUser("superadmin")
                .password(passwordEncoder.encode("superadmin"))
                .roles("USER", "ADMIN", "SUPERADMIN")

                .and()
                .withUser("LYNN").password(passwordEncoder.encode("lynn")).roles("ADMIN")

                .and()
                .withUser("TOM").password(passwordEncoder.encode("tom")).roles("SUPERADMIN")

                ;
//                .and()
//                .withUser("junebug").password(passwordEncoder.encode("junebug")).roles("USER");

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/static/**")
                .antMatchers("/**/*.css")
//                .antMatchers("/**/*.gif")
//                .antMatchers("/**/*.jpg")
//                .antMatchers("/**/*.mp4")
                .antMatchers("/h2-console/**");
    }
}
