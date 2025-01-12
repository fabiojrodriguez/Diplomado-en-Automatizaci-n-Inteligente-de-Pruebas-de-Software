import com.intuit.karate.junit5.Karate;
import io.qameta.allure.karate.AllureKarate;

public class ExampleTest {

    @Karate.Test
    public Karate testApi() {
        return Karate
                .run("reqresTest").relativeTo(getClass())
                .hook(new AllureKarate())
                .relativeTo(getClass())
                .outputJunitXml(true);
    }
}