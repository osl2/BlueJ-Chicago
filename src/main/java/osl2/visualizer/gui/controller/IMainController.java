package osl2.visualizer.gui.controller;

import osl2.Chicago.ChicagoDatastructure;

/**
 * Defines the interface of the main controller of MVC.
 * The main controller is responsible for controlling the view.
 */
public interface IMainController {

	/**
	 * Set the current playspeed.
	 *
	 * @param playspeed - the new playspeed
	 */
	void setPlayspeed(int playspeed);

	/**
	 * Play or pause the playback of the changes to datastructures.
	 * If the playback is currently playing it will be paused
	 * otherwise it will be played.
	 */
	void playOrPause();

	/**
	 * Play one change to a data structure.
	 */
	void playStep();

	/**
	 * Register a data structure.
	 *
	 * @param chicagoDatastructure the data structure to be registered
	 */
	void registerDatastructure(ChicagoDatastructure chicagoDatastructure);
}
