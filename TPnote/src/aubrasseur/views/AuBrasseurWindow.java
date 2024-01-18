package aubrasseur.views;
import aubrasseur.Controllers.AuBrasseurControlleur;
import aubrasseur.Models.CashDesk;
import aubrasseur.Models.Observer.Observer;

import javax.swing.*;

public class AuBrasseurView extends JFrame implements Observer {
    private CashDesk model;
    private AuBrasseurControlleur controller;

    public AuBrasseurView(CashDesk model, AuBrasseurControlleur controller) {
        this.model = model;
        this.controller = controller;



    }
