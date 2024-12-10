package oncall;

import oncall.controller.OncallController;
import oncall.global.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        OncallController oncallController = AppConfig.INSTANCE.createOncallController();
        oncallController.start();
    }
}
