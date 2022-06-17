package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.service.VendingMachineService;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_PURCHASE= "Purchase";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_PURCHASE, PURCHASE_MENU_FINISH_TRANSACTION };



	private Menu menu;
	private VendingMachineService vendingMachineService;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		vendingMachineService = new VendingMachineService();
	}

	public void run() {

		vendingMachineService.logMessage();

		boolean running = true;

		while (running) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				runPurchaseMenu();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
//				System.exit(0);
				running = false;
			}
		}
	}

	public void runPurchaseMenu() {

		boolean running = true;

		while (running) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				vendingMachineService.feedMoney();
			} else if (choice.equals(PURCHASE_MENU_OPTION_PURCHASE)) {
				vendingMachineService.maskePurchase();
			} else if (choice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
				String changeMsg = vendingMachineService.makeChange();
				System.out.println(changeMsg);
				running = false;

//				System.exit(0);   DON'T DO THIS!!!!!
			}
		}

	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
