package aubrasseur.views;
import aubrasseur.Controllers.AuBrasseurControlleur;
import aubrasseur.Models.Bierre;
import aubrasseur.Models.CashDesk;
import aubrasseur.Models.Observer.Observer;
import aubrasseur.Models.Tarte;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AuBrasseurWindow extends JFrame implements Observer {
    private CashDesk model;
    private AuBrasseurControlleur controller;

    private JPanel BierreTartepanel  = new JPanel();

    private JPanel AffichageTarteBierre = new JPanel();

    private JPanel resetEtencaisser = new JPanel();

    private JPanel total = new JPanel();

    JLabel totalBierreLabel = new JLabel("Total Bierre: ");
    JLabel totalTartelabel= new JLabel("Total Tarte: ");
    JLabel totalabel = new JLabel("Total: ");
    JLabel tableslabel = new JLabel("Tables: ");

    public AuBrasseurWindow(CashDesk model, AuBrasseurControlleur controller) {
        this.model = model;
        this.controller = controller;

        this.setLayout(new BorderLayout());
        //bieretartepanel
        BierreTartepanel.setLayout(new GridLayout(7,1));
        BierreTartepanel.add(new JLabel("Ajouter une bierre:"));
        JButton IPA = new JButton("Indian Pale Ale");
        IPA.addActionListener(e -> controller.addBierre("IndianPale"));
        JButton sansAlcool = new JButton("Sans Alcool");
        sansAlcool.addActionListener(e -> controller.addBierre("BierreSansAlcool"));
        BierreTartepanel.add(IPA);
        BierreTartepanel.add(sansAlcool);
        BierreTartepanel.add(new JLabel("Ajouter une tarte:"));
        JButton Traditionnelle = new JButton("Traditionnelle");
        Traditionnelle.addActionListener(e -> controller.addTarte("TarteTraditionnelle"));
        JButton munster = new JButton("Munster");
        munster.addActionListener(e -> controller.addTarte("TarteMunster"));
        JButton Hawaïenne = new JButton("Hawaïenne");
        Hawaïenne.addActionListener(e -> controller.addTarte("TarteHawai"));
        BierreTartepanel.add(Traditionnelle);
        BierreTartepanel.add(munster);
        BierreTartepanel.add(Hawaïenne);

        //resetEtencaisser

        resetEtencaisser.setLayout(new GridLayout(2,1));
        JButton reset = new JButton("Reset");
        reset.addActionListener(e -> controller.reset());
        JButton encaisser = new JButton("Encaisser");
        encaisser.addActionListener(e -> controller.encaisser());
        resetEtencaisser.add(reset);
        resetEtencaisser.add(encaisser);
        this.add(resetEtencaisser, BorderLayout.EAST);





        BierreTartepanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(BierreTartepanel, BorderLayout.WEST);

        //AffichageTarteBierre

        AffichageTarteBierre.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(AffichageTarteBierre, BorderLayout.CENTER);

        //total
        total.setLayout(new BoxLayout(total, BoxLayout.X_AXIS));
        total.add(totalBierreLabel);
        total.add(totalTartelabel);
        total.add(totalabel);
        total.add(tableslabel);
        this.add(total, BorderLayout.SOUTH);





        this.setPreferredSize(new java.awt.Dimension(800, 300));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }


    @Override
    public void updateTotal(double total) {

        totalabel.setText("Total: "+total);

    }

    @Override
    public void updateAffichage(List<Bierre> bierres, List<Tarte> tartes) {
        // remove all bierres
        AffichageTarteBierre.removeAll();
        AffichageTarteBierre.setLayout(new GridLayout(bierres.size(), 1));
        for (Bierre bierre : bierres) {
            AffichageTarteBierre.add(new JLabel(bierre.desc()));
        }
        for (Tarte tarte : tartes) {
            AffichageTarteBierre.add(new JLabel(tarte.desc()));
        }
        AffichageTarteBierre.revalidate();
        AffichageTarteBierre.repaint();
    }
    @Override
    public void updateTotalBierre(double totalBierre) {

        totalBierreLabel.setText("Total Bierre: "+totalBierre);






    }

    @Override
    public void updateTotalTarte(double totalTarte) {

        totalTartelabel.setText("Total Tarte: "+totalTarte);


    }

    @Override
    public void updateTables(int tables) {

        tableslabel.setText("Tables: "+tables);

    }
}
