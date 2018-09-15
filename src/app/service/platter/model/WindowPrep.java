package app.service.platter.model;

public interface WindowPrep
{
	void loadDefaultConfig();
	void configure();
	void refreshCfg();

	void prepare();
	void cook();
	void serve();
	void showWindow();
}
