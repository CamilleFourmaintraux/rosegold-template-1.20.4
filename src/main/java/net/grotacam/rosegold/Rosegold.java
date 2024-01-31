package net.grotacam.rosegold;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rosegold implements ModInitializer {

	public static final String MOD_ID = "rosegold";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Rosegold Mod");
	}
}