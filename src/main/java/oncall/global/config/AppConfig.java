package oncall.global.config;

import oncall.controller.OncallController;
import oncall.view.InputView;
import oncall.view.OutputView;
import oncall.view.View;

public enum AppConfig {
    INSTANCE;

    public OncallController createOncallController() {
        return new OncallController(createView());
    }

    public View createView() {
        return new View(createInputView(), createOutputView());
    }

    private InputView createInputView() {
        return new InputView();
    }

    private OutputView createOutputView() {
        return new OutputView();
    }
}
