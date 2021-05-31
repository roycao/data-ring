package com.meet2025.dataring;

import com.meet2025.dataring.domain.DataCatalog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class IntegrationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testGetDataCatalog() {
        ResponseEntity<DataCatalog> response = testRestTemplate.getForEntity("/datacatalogs/organization", DataCatalog.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo("Organization");
        assertThat(response.getBody().getDescription()).isEqualTo("Organization Info");
    }

    @Test
    public void TestAddDataCatalog(){
        DataCatalog dataCatalog = new DataCatalog("Mobile","Mobile catalog info");
        ResponseEntity<DataCatalog> response = testRestTemplate.postForEntity("/datacatalogs", dataCatalog, DataCatalog.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo(dataCatalog.getName());
        assertThat(response.getBody().getId()).isGreaterThan(0L);
    }

}
