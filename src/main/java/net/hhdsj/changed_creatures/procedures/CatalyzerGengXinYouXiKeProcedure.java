package net.hhdsj.changed_creatures.procedures;

import net.hhdsj.changed_creatures.network.GoodblockModVariables;

public class CatalyzerGengXinYouXiKeProcedure {
	public static void execute() {
		if (GoodblockModVariables._Progress >= 100) {
			GoodblockModVariables._Progress = 0;
		} else {
			GoodblockModVariables._Progress = GoodblockModVariables._Progress + 1;
		}
	}
}
