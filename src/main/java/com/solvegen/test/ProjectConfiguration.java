package com.solvegen.test;

import com.solvegen.test.dao.DaoContextConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Maksim Ahramovich
 */
@Configuration
@Import({DaoContextConfiguration.class})
public class ProjectConfiguration {
}
