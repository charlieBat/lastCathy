import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
class ManagerUI extends JFrame {

    Manager manager;
    private final int WIDTH = 500, HEIGHT = 130;
    public int managerID;

    ManagerUI() {
        setSize(WIDTH, HEIGHT);
        setTitle("ManagerUI");
        setVisible(false);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        draw();
        this.manager = new Manager();
        LoginUI loginUI = new LoginUI(this, "Manager", manager);
        loginUI.setVisible(true);
        loginUI.setResizable(false);
    }

    private JPanel buttonsPanel, northPanel;
    private buttonHandler handler;

    public void draw() {
        setLayout(new BorderLayout());
        handler = new buttonHandler();
        drawNorthPanel();
        add(northPanel, BorderLayout.NORTH);
        drawButtons();
        add(buttonsPanel, BorderLayout.CENTER);
    }

    public void repaint() {
        setVisible(true);
        displayID.setText(managerID + "");
    }

    JButton manageItem, manageEmployee, manageDeal;
    JButton getSalesRecord, getTotalTransactionAmount, getMinMaxWage;
    JButton getMinMaxPrice, division;

    private void drawButtons() {
        buttonsPanel = new JPanel();
        manageItem = new JButton("Manage Items");
        manageItem.addActionListener(handler);
        manageEmployee = new JButton("Manage Employee");
        manageEmployee.addActionListener(handler);
        manageDeal = new JButton("Manage Deal");
        manageDeal.addActionListener(handler);
        buttonsPanel.setLayout(new GridLayout(3, 3));
        getSalesRecord = new JButton("Get Sales Record");
        getSalesRecord.addActionListener(handler);
        getTotalTransactionAmount = new JButton("Get Total Transaction Amount");
        getTotalTransactionAmount.addActionListener(handler);
        getMinMaxWage = new JButton("Get Min Max Wage Clerk");
        getMinMaxWage.addActionListener(handler);
        getMinMaxPrice = new JButton("Get Average Item Price");
        getMinMaxPrice.addActionListener(handler);
        division = new JButton("Find special Purchase");
        division.addActionListener(handler);

        buttonsPanel.add(manageItem);
        buttonsPanel.add(manageEmployee);
        buttonsPanel.add(manageDeal);
        buttonsPanel.add(getSalesRecord);
        buttonsPanel.add(getTotalTransactionAmount);
        buttonsPanel.add(getMinMaxWage);
        buttonsPanel.add(getMinMaxPrice);
        buttonsPanel.add(division);
    }

    private JLabel friendly, displayID;
    private JButton logOut;

    private void drawNorthPanel() {
        northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 3));
        friendly = new JLabel("Manager ID: ");
        northPanel.add(friendly);
        displayID = new JLabel(managerID + "");
        displayID.setForeground(Color.BLUE);
        northPanel.add(displayID);
        logOut = new JButton("Log Out");
        logOut.addActionListener(handler);
        northPanel.add(logOut);
    }

    private ManageEmployee employees;
    private ManageItem items;
    private ManageDeal deals;
    private GetSalesRecord salesRecord;
    private GetTotalTransaction totalTransaction;
    private GetMinMaxWage minMaxWage;
    private GetMinMaxPrice minMaxPrice;
    private Division Division;

    // todo private Division
    private class buttonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == manageItem) {
                if (items == null)
                    manageItem();
                else {
                    items.setVisible(false);
                    items.dispose();
                    items = null;
                }
            } else if (source == manageEmployee) {
                if (employees == null)
                    manageEmployee();
                else {
                    employees.setVisible(false);
                    employees.dispose();
                    employees = null;
                }
            } else if (source == manageDeal) {
                if (deals == null)
                    manageDeal();
                else {
                    deals.setVisible(false);
                    deals.dispose();
                    deals = null;
                }
            } else if (source == getSalesRecord) {
                if (salesRecord == null)
                    getSalesRecord();
                else {
                    salesRecord.setVisible(false);
                    salesRecord.dispose();
                    salesRecord = null;
                }
            } else if (source == getTotalTransactionAmount) {
                if (totalTransaction == null)
                    getTotalTransactionAmount();
                else {
                    totalTransaction.setVisible(false);
                    totalTransaction.dispose();
                    totalTransaction = null;
                }
            } else if (source == getMinMaxWage) {
                if (minMaxWage == null)
                    getMinMaxWage();
                else {
                    minMaxWage.setVisible(false);
                    minMaxWage.dispose();
                    minMaxWage = null;
                }
            } else if (source == getMinMaxPrice) {
                if (minMaxPrice == null)
                    getMinMaxPrice();
                else {
                    minMaxPrice.setVisible(false);
                    minMaxPrice.dispose();
                    minMaxPrice = null;
                }

            } else if (source == division) {
                if (Division == null)
                    findPurchasesContainsAllItemsOnSale();
                else {
                    Division.setVisible(false);
                    Division.dispose();
                    Division = null;
                }

            } else if (source == logOut) {
                    logOut();
                }

        }

        private void logOut() {
            LoginUI loginUI = new LoginUI(this, "Manager", manager);
            loginUI.setVisible(true);
            setVisible(false);
        }

        private void manageEmployee() {
            employees = new ManageEmployee(manager);
            employees.setVisible(true);
        }

        private void manageDeal() {
            deals = new ManageDeal(manager);
            deals.setVisible(true);
        }

        private void manageItem() {
            items = new ManageItem(manager);
            items.setVisible(true);
        }

        private void getSalesRecord() {
            salesRecord = new GetSalesRecord(manager);
            salesRecord.setVisible(true);
        }

        private void getTotalTransactionAmount() {
            totalTransaction = new GetTotalTransaction(manager);
            totalTransaction.setVisible(true);
        }

        private void getMinMaxWage() {
            minMaxWage = new GetMinMaxWage(manager);
            minMaxWage.setVisible(true);
        }

        private void getMinMaxPrice() {
            minMaxPrice = new GetMinMaxPrice(manager);
            minMaxPrice.setVisible(true);
        }

        private void findPurchasesContainsAllItemsOnSale() {
            Division = new Division(manager);
            Division.setVisible(true);
        }
    }
}