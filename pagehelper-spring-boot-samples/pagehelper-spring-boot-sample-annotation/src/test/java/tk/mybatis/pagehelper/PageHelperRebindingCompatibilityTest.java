package tk.mybatis.pagehelper;

import com.github.pagehelper.autoconfigure.PageHelperProperties;
import com.github.pagehelper.autoconfigure.PageHelperStandardProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = SampleMapperApplication.class)
class PageHelperRebindingCompatibilityTest {

    @Autowired
    private PageHelperStandardProperties standardProperties;
    @Autowired
    private PageHelperProperties pageHelperProperties;

    @Test
    void shouldSupportDefaultConstructorInstantiationForRebinderPath() {
        PageHelperStandardProperties rebound = BeanUtils.instantiateClass(PageHelperStandardProperties.class);
        assertNotNull(rebound);
        assertNotNull(rebound.getProperties());
    }

    @Test
    void shouldInjectSharedPageHelperPropertiesIntoStandardPropertiesBean() {
        assertSame(pageHelperProperties, standardProperties.getProperties());
        assertTrue(pageHelperProperties.getOffsetAsPageNum());
        assertEquals("*", pageHelperProperties.getProperty("countColumn"));
    }
}
