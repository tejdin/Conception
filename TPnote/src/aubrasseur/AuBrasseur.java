package aubrasseur;

import aubrasseur.Controllers.AuBrasseurControlleur;
import aubrasseur.Models.CashDesk;
import aubrasseur.views.AuBrasseurWindow;

public class AuBrasseur {

	public static void main(String[] args) {


		CashDesk model = new CashDesk();
		AuBrasseurControlleur controller = new AuBrasseurControlleur(model);
		AuBrasseurWindow view = new AuBrasseurWindow(model,controller);
		model.addObserver(view);


	}

}
