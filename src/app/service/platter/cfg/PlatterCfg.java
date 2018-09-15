package app.service.platter.cfg;

import javafx.scene.Scene;
import javafx.stage.Modality;

public class PlatterCfg
{
	/* CONFIGURABLES */
	protected Scene firstScreen;

	protected String windowTitle;

	protected double minWindowWidth;
	protected double minWindowHeight;

	protected Modality modality;

	protected boolean closeToProceed;
	protected boolean borderlessWindow;
	protected boolean grippyWindow;

	public PlatterCfg setFirstScreen(Scene firstScreen) {
		this.firstScreen = firstScreen;
		return this;
	}

	public PlatterCfg setWindowTitle(String windowTitle) {
		this.windowTitle = windowTitle;
		return this;
	}

	public PlatterCfg setMinWindowWidth(double minWindowWidth) {
		this.minWindowWidth = minWindowWidth;
		return this;
	}

	public PlatterCfg setMinWindowHeight(double minWindowHeight) {
		this.minWindowHeight = minWindowHeight;
		return this;
	}

	public PlatterCfg setModality(Modality modality) {
		this.modality = modality;
		return this;
	}

	public PlatterCfg setCloseToProceed(boolean closeToProceed) {
		this.closeToProceed = closeToProceed;
		return this;
	}

	public PlatterCfg setBorderlessWindow(boolean borderlessWindow) {
		this.borderlessWindow = borderlessWindow;
		return this;
	}

	public PlatterCfg setGrippyWindow(boolean grippyWindow) {
		this.grippyWindow = grippyWindow;
		return this;
	}

	public Scene getFirstScreen() {
		return firstScreen;
	}

	public String getWindowTitle() {
		return windowTitle;
	}

	public double getMinWindowWidth() {
		return minWindowWidth;
	}

	public double getMinWindowHeight() {
		return minWindowHeight;
	}

	public Modality getModality() {
		return modality;
	}

	public boolean isCloseToProceed() {
		return closeToProceed;
	}

	public boolean isBorderlessWindow() {
		return borderlessWindow;
	}

	public boolean isGrippyWindow() {
		return grippyWindow;
	}
}
