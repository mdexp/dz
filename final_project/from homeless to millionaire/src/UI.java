import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class UI {
    private JFrame mainFrame;
    private JButton shopButton, inventoryButton, clickerButton;
    private JLabel balanceLabel, rankLabel;
    private double balance = 0.0;
    private double clickValue = 1.0;
    private Map<String, Integer> inventory = new HashMap<>();
    private boolean boostActive = false;
    private JFrame frame;
    private JPanel productPanel;

    public UI() {
        mainFrame = new JFrame("Store");
        mainFrame.setSize(450, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1));
        balanceLabel = new JLabel("Balance: $" + balance, SwingConstants.CENTER);
        rankLabel = new JLabel("Rank: Бомж", SwingConstants.CENTER);
        topPanel.add(balanceLabel);
        topPanel.add(rankLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        shopButton = new JButton("Open Store");
        inventoryButton = new JButton("Inventory");
        clickerButton = new JButton("Clicker");


        shopButton.setBackground(Color.YELLOW);
        inventoryButton.setBackground(Color.YELLOW);
        clickerButton.setBackground(Color.YELLOW);

        buttonPanel.add(shopButton);
        buttonPanel.add(inventoryButton);
        buttonPanel.add(clickerButton);

        shopButton.addActionListener(e -> new StoreWindow());
        inventoryButton.addActionListener(e -> showInventory());
        clickerButton.addActionListener(e -> new ClickerWindow());

        mainFrame.add(topPanel, BorderLayout.NORTH);
        mainFrame.add(buttonPanel, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }

    private void showInventory() {
        StringBuilder inventoryText = new StringBuilder("Inventory:\n");
        if (inventory.isEmpty()) {
            inventoryText.append("No items");
        } else {
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                inventoryText.append(entry.getKey()).append(" x").append(entry.getValue()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(mainFrame, inventoryText.toString(), "Inventory", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateRank() {
        String rank;
        Color rankColor;
        if (balance < 100) {
            rank = "Бомж";
            rankColor = new Color(139, 69, 19);
        } else if (balance < 1000) {
            rank = "Бедный";
            rankColor = new Color(255, 215, 0);
        } else if (balance < 10000) {
            rank = "Богатый";
            rankColor = new Color(0, 128, 0);
        } else {
            rank = "Миллионер";
            rankColor = new Color(255, 0, 255);
        }
        rankLabel.setText("Rank: " + rank);
        rankLabel.setForeground(rankColor);
    }

    class ClickerWindow {
        private JFrame frame;
        private JButton clickButton;

        public ClickerWindow() {
            frame = new JFrame("Clicker");
            frame.setSize(400, 300);
            frame.setLayout(new GridLayout(5, 1));

            clickButton = new JButton("Click (+$" + clickValue + ")");
            clickButton.addActionListener(e -> {
                balance += clickValue;
                balanceLabel.setText("Balance: $" + balance);
                updateRank();
            });

            clickButton.setBackground(Color.RED);
            frame.add(clickButton);
            addBoost(frame, "x2 Boost (30s)", 50, 30000, 2);
            addBoost(frame, "x3 Boost (50s)", 75, 50000, 50);
            addBoost(frame, "x5 Boost (1 min)", 100, 60000, 5);
            addBoost(frame, "x10 Boost (2 min)", 500, 120000, 10);
            addBoost(frame, "x50 Boost (5 min)", 1000, 300000, 50);
            addBoost(frame, "x75 Boost (10 min)", 2500, 600000, 75);
            addBoost(frame, "x100 Boost (30 min)", 5, 1800000, 100);
            frame.setVisible(true);
        }

        private void addBoost(JFrame frame, String name, double price, int duration, int multiplier) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel label = new JLabel(name + " - $" + price);
            JButton buyButton = new JButton("Buy");

            buyButton.addActionListener(e -> {
                if (balance >= price) {
                    balance -= price;
                    balanceLabel.setText("Balance: $" + balance);
                    updateRank();
                    activateBoost(duration, multiplier);
                } else {
                    JOptionPane.showMessageDialog(frame, "Not enough funds!");
                }
            });

            panel.add(label);
            panel.add(buyButton);
            frame.add(panel);
        }

        private void activateBoost(int duration, int multiplier) {
            if (boostActive) return;
            boostActive = true;
            clickValue *= multiplier;
            clickButton.setText("Click (+$" + clickValue + ")");

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clickValue /= multiplier;
                    clickButton.setText("Click (+$" + clickValue + ")");
                    boostActive = false;
                }
            }, duration);
        }
    }

    class StoreWindow {
        private JFrame frame;

        public StoreWindow() {
            frame = new JFrame("Store");
            frame.setSize(300, 250);
            frame.setLayout(new BorderLayout());

            productPanel = new JPanel();
            productPanel.setLayout(new GridLayout(0, 1));

            addProduct("Apple", 2.0);
            addProduct("Socks", 5.0);
            addProduct("Newspaper", 5.0);
            addProduct("Magazine", 10.0);
            addProduct("Tie", 10.0);
            addProduct("Smartphone case", 25.0);
            addProduct("Scarf", 25.0);
            addProduct("Umbrella", 15.0);
            addProduct("Hat", 30.0);
            addProduct("Belt", 30.0);
            addProduct("Phone", 200.0);
            addProduct("Blender", 150.0);
            addProduct("Watch", 150.0);
            addProduct("Gloves", 20.0);
            addProduct("Shirt", 50.0);
            addProduct("T-shirt", 50.0);
            addProduct("Fan", 50.0);
            addProduct("Backpack", 100.0);
            addProduct("Jeans", 100.0);
            addProduct("Sweater", 200.0);
            addProduct("Laptop bag", 50.0);
            addProduct("Laptop", 1000.0);
            addProduct("Microwave", 200.0);
            addProduct("Smartphone", 1000.0);
            addProduct("Camera", 3000.0);
            addProduct("Sound system", 5000.0);
            addProduct("Grill", 1000.0);
            addProduct("Drone", 2000.0);
            addProduct("Air conditioner", 500.0);
            addProduct("Smart watch", 250.0);
            addProduct("Iron", 100.0);
            addProduct("Washing machine", 700.0);
            addProduct("Refrigerator", 1500.0);
            addProduct("TV", 1000.0);
            addProduct("Fitness tracker", 100.0);
            addProduct("Game console", 300.0);
            addProduct("Sewing machine", 300.0);
            addProduct("Tablet", 400.0);
            addProduct("Smart glasses", 1500.0);
            addProduct("Heater", 150.0);
            addProduct("Toaster", 100.0);
            addProduct("Mixer", 150.0);
            addProduct("Blender", 150.0);
            addProduct("TV stand", 200.0);
            addProduct("Refrigerator", 1500.0);
            addProduct("Coffee machine", 500.0);
            addProduct("Iron", 100.0);
            addProduct("Spacecraft", 500000000);
            addProduct("Luxury car", 1000000);
            addProduct("Motorbike", 10000);
            addProduct("Gold bar", 1000000);
            addProduct("Piano", 100000);
            addProduct("Jet", 2000000);
            addProduct("Luxury watch", 100000);
            addProduct("Diamond ring", 2000000);
            addProduct("Space station", 1000000);
            addProduct("Safari trip", 20000);
            addProduct("Private jet", 5000000);
            addProduct("Lamborghini", 2000000);
            addProduct("Ferrari", 1500000);
            addProduct("Tesla", 500000);
            addProduct("Luxe yacht", 20000000);
            addProduct("Guitar", 10000);
            addProduct("Diamond", 10000000);
            addProduct("Private island", 50000000);
            addProduct("Gold necklace", 500000);
            addProduct("Gold ring", 10000.0);
            addProduct("Sapphire", 150000);
            addProduct("Emerald", 120000);
            addProduct("Ruby", 200000);
            addProduct("Swimming pool", 100000);
            addProduct("Luggage set", 400.0);
            addProduct("Barbecue", 2000.0);
            addProduct("Jet ski", 150000);
            addProduct("Antique chair", 3000.0);
            addProduct("Luxury villa", 5000000);
            addProduct("Vintage wine", 50000.0);
            addProduct("Luxury apartment", 1000000.0);
            addProduct("Helicopter", 10000000);
            addProduct("Luxury house", 10000000);
            addProduct("Private island", 50000000);
            addProduct("Antique book", 2000.0);
            addProduct("Mountain cabin", 100000);
            addProduct("Supercomputer", 5000000);
            addProduct("Smartphone", 2000.0);
            addProduct("Luxury yacht", 5000000);
            addProduct("Swimming pool", 1000000);
            addProduct("Ferrari", 1500000);
            addProduct("Game console", 300.0);
            addProduct("Jet ski", 10000);
            addProduct("Yacht", 5000000);
            addProduct("Space station", 1000000000000.0);
            addProduct("Big house", 100000);
            addProduct("Earth", 600000000000000.0);


            JScrollPane scrollPane = new JScrollPane(productPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setVisible(true);
        }

        private void addProduct(String name, double basePrice) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel label = new JLabel(name + " - $" + basePrice);
            JButton buyButton = new JButton("Buy");

            buyButton.addActionListener(e -> {
                if (balance >= basePrice) {
                    balance -= basePrice;
                    balanceLabel.setText("Balance: $" + balance);
                    updateRank();
                    inventory.put(name, inventory.getOrDefault(name, 0) + 1);
                } else {
                    JOptionPane.showMessageDialog(frame, "Not enough funds!");
                }
            });

            panel.add(label);
            panel.add(buyButton);
            productPanel.add(panel);
        }
    }
}