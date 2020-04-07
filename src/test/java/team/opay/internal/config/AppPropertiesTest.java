package team.opay.internal.config;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class AppPropertiesTest {

    @Test
    public void getInstance() {
        assertThat(AppProperties.getInstance()).isNotNull();
    }
}