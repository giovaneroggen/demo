package br.com.product.data;

import br.com.tests.SpringApplicationTests;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by giovane.silva on 28/09/2017.
 */
@ContextConfiguration("classpath:/elasticsearch-context.xml")
public abstract class ElasticSearchSpringApplicationTest extends SpringApplicationTests {

}
