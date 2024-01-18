package aubrasseur;

import controller.AuBrasseurController;
import model.CashDesk;
import view.AuBrasseurWindow;

public class AuBrasseur {

	public static void main(String[] args) {
		CashDesk model = new CashDesk();
		AuBrasseurController controller = new AuBrasseurController(model);
		AuBrasseurWindow view = new AuBrasseurWindow(model,controller);
		model.addObserver(view);
	}

}
