package tk.mybatis.pagehelper;

import com.github.pagehelper.autoconfigure.PageHelperProperties;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import com.github.pagehelper.autoconfigure.PageHelperStandardProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = SampleMapperApplication.class)
@TestPropertySource(properties = {
        "pagehelper.reasonable=true",
        "pagehelper.helper-dialect=mysql",
        "pagehelper.async-count-parallelism=8",
        "pagehelper.count-column=id",
        "pagehelper.customFlag=enabled",
        "pagehelper.customMode=strict"
})
class PageHelperRebindingCompatibilityTest {

    @Autowired
    private PageHelperStandardProperties standardProperties;
    @Autowired
    private PageHelperProperties pageHelperProperties;
    @Autowired
    private PageHelperAutoConfiguration autoConfiguration;

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
        assertEquals("id", pageHelperProperties.getProperty("countColumn"));
    }

    @Test
    void shouldBindStandardAndCustomPropertiesForStandardAndAutoConfigurationPaths() {
        assertTrue(standardProperties.getReasonable());
        assertEquals("mysql", standardProperties.getHelperDialect());
        assertEquals(8, standardProperties.getAsyncCountParallelism());

        assertEquals("enabled", standardProperties.getProperties().getProperty("customFlag"));
        assertEquals("strict", standardProperties.getProperties().getProperty("customMode"));

        PageHelperProperties autoConfigurationProperties =
                (PageHelperProperties) ReflectionTestUtils.getField(autoConfiguration, "properties");
        assertNotNull(autoConfigurationProperties);
        assertSame(standardProperties.getProperties(), autoConfigurationProperties);
        assertTrue(autoConfigurationProperties.getReasonable());
        assertEquals("mysql", autoConfigurationProperties.getHelperDialect());
        assertEquals(8, autoConfigurationProperties.getAsyncCountParallelism());
        assertEquals("enabled", autoConfigurationProperties.getProperty("customFlag"));
        assertEquals("strict", autoConfigurationProperties.getProperty("customMode"));
    }
}
