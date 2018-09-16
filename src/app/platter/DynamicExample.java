package app.platter;

import app.view.dynamics.DynamicFieldList;
import app.view.dynamics.DynamicList;
import app.controller.frame.FrameCtrl;
import app.service.platter.model.Platter;
import app.service.platter.sectionManager.Section;
import javafx.scene.input.KeyCode;

public class DynamicExample extends Platter
{
	private Section frame;
	private Section listSection;
	private Section movingTargetSection;

	@Override
	public void loadSections() {
		frame = Section.create()
				.fromFXML("/app/view/frame/frame.fxml")
				.withInternalScreen(600, 600);

		listSection = Section.create()
				.fromFXML("/app/view/dynamics/dynamicList.fxml");

		movingTargetSection = Section.create()
				.fromFXML("/app/view/dynamics/dynamicFieldList.fxml");
	}

	@Override
	public void loadDocks() {

	}

	@Override
	public void configure() {
		cfg
				.setFirstScreen(frame.getInternalScreen());

		mainWindow.setResizable(true);
	}

	@Override
	public void prepare() {
		// Get controllers
		FrameCtrl frameCtrl = (FrameCtrl) frame.getController();
		DynamicList dynamicList = (DynamicList) listSection.getController();
		DynamicFieldList dynamicFieldList = (DynamicFieldList) movingTargetSection.getController();

		// Scroll to bottom at start
		dynamicList.getScroll().vvalueProperty().bind(dynamicList.getFeedBox().heightProperty());
		dynamicFieldList.getScroll().vvalueProperty().bind(dynamicFieldList.getFeedBox().heightProperty());

		// Set list as default section
		frameCtrl.getListNav().getStyleClass().add("navCurrent");
		frameCtrl.show(listSection.getLayout());


		// Handle nav buttons
		frameCtrl.getListNav().setOnAction(e -> {
			frameCtrl.getListNav().getStyleClass().add("navCurrent");
			frameCtrl.getMovingTargetNav().getStyleClass().remove("navCurrent");
			frameCtrl.show(listSection.getLayout());
			frameCtrl.getFooter().setVisible(true);
		});
		frameCtrl.getMovingTargetNav().setOnAction(e -> {
			frameCtrl.getListNav().getStyleClass().remove("navCurrent");
			frameCtrl.getMovingTargetNav().getStyleClass().add("navCurrent");
			frameCtrl.show(movingTargetSection.getLayout());
			frameCtrl.getFooter().setVisible(false);
		});


		// Enter key as submit
		frameCtrl.getInputField().setOnKeyPressed((keyEvent) -> {
			if (keyEvent.getCode().equals(KeyCode.ENTER)) {
				dynamicList.insert(frameCtrl.getInputField().getText());
				frameCtrl.getInputField().setText("");
			}
		});
	}
}
