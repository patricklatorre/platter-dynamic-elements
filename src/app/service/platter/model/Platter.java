package app.service.platter.model;

import app.service.platter.cfg.PlatterCfg;
import app.service.platter.sectionManager.Section;
import app.service.platter.windowManager.WindowGrip;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class Platter implements Sectioned, WindowPrep
{
	protected Stage mainWindow;

	/* DEFAULT SECTION */
	protected Section nullSection;

	/* CONFIGURATION */
	protected PlatterCfg cfg;

	public void loadDefaultSection() {
		nullSection = Section.create()
				.fromFXML("/app/view/NULL/Default.fxml")
				.withInternalScreen(300, 300);
	}

	public void loadDefaultConfig() {
		cfg = new PlatterCfg()
				.setWindowTitle("Platter")
				.setFirstScreen(nullSection.getInternalScreen())
				.setMinWindowHeight(1)
				.setMinWindowWidth(1)
				.setModality(Modality.NONE)
				.setCloseToProceed(false)
				.setBorderlessWindow(false)
				.setGrippyWindow(false);

		mainWindow = new Stage();
	}

	public void cook() {
		refreshCfg();
	}

	public void showWindow() {
		if (cfg.isCloseToProceed()) {
			mainWindow.showAndWait();
		} else {
			mainWindow.show();
		}
	}

	public void refreshCfg() {
		mainWindow.setTitle(
				cfg.getWindowTitle()
		);
		mainWindow.setMinWidth(
				cfg.getMinWindowWidth()
		);
		mainWindow.setMinHeight(
				cfg.getMinWindowHeight()
		);
		mainWindow.initModality(
				cfg.getModality()
		);


		if (cfg.isBorderlessWindow()) {
			mainWindow.initStyle(StageStyle.UNDECORATED);
		}
		if (cfg.isGrippyWindow()) {
			WindowGrip.rubberize(mainWindow, cfg.getFirstScreen());
		}

		mainWindow.setScene(cfg.getFirstScreen());
	}

	public void serve() {
		loadDefaultSection();
		loadDefaultConfig();
		loadSections();
		loadDocks();
		configure();
		prepare();
		cook();
		showWindow();
	}
}
