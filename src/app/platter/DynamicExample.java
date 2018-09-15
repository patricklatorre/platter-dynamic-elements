package app.platter;

import app.view.dynamics.DynamicList;
import app.controller.frame.FrameCtrl;
import app.service.platter.model.Platter;
import app.service.platter.sectionManager.Section;
import javafx.scene.input.KeyCode;

public class DynamicExample extends Platter
{
	private Section frame;
	private Section listSection;

	@Override
	public void loadSections() {
		frame = Section.create()
				.fromFXML("/app/view/frame/frame.fxml")
				.withInternalScreen(600, 600);

		listSection = Section.create()
				.fromFXML("/app/view/dynamics/dynamicList.fxml");
	}

	@Override
	public void loadDocks() {

	}

	@Override
	public void configure() {
		cfg
				.setFirstScreen(frame.getInternalScreen());
	}

	@Override
	public void prepare() {
		// Get controllers
		FrameCtrl frameCtrl = (FrameCtrl) frame.getController();
		DynamicList dynamicList = (DynamicList) listSection.getController();

		// Scroll to bottom at start
		dynamicList.getScroll().vvalueProperty().bind(dynamicList.getFeedBox().heightProperty());

		// Set list as default section
		frameCtrl.show(listSection.getLayout());

		// Enter key as submit
		frameCtrl.getInputField().setOnKeyPressed((keyEvent) -> {
			if (keyEvent.getCode().equals(KeyCode.ENTER)) {
				dynamicList.insert(frameCtrl.getInputField().getText());
				frameCtrl.getInputField().setText("");
			}
		});
	}


}
