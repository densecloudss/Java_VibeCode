import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class HelloWorld {
    private static Point mouseOffset;
    private static final String TELEGRAM_LINK = "https://t.me/Chromantica";
    private static final String SECOND_TELEGRAM_LINK = "https://t.me/kitiiiuu";
    private static boolean showSecondEasterEgg = false;
    private static int puzzleAttempts = 0;

    public static void main(String[] args) {
        // Создаем и настраиваем окно
        JFrame frame = new JFrame("Результаты программы");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        
        // Включаем поддержку прозрачности
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        
        // Создаем панель с эффектом матового стекла
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                
                Color darkGlass = new Color(30, 30, 30, 150);
                g2d.setColor(darkGlass);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                
                // Рисуем скрытую букву R
                g2d.setColor(new Color(255, 0, 0, 30));
                g2d.setFont(new Font("Arial", Font.BOLD, 24));
                g2d.drawString("R", getWidth() - 40, getHeight() - 20);

                // Рисуем вторую пасхалку, если она разблокирована
                if (showSecondEasterEgg) {
                    g2d.setColor(new Color(255, 0, 0, 30));
                    g2d.setFont(new Font("Arial", Font.BOLD, 24));
                    g2d.drawString("R", 40, getHeight() - 20);
                }
            }
        };
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setOpaque(false);

        // Добавляем обработчик клика для пасхалок
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Проверяем клик по первой пасхалке (R)
                if (e.getX() >= panel.getWidth() - 60 && e.getX() <= panel.getWidth() - 20 &&
                    e.getY() >= panel.getHeight() - 40 && e.getY() <= panel.getHeight() - 10) {
                    try {
                        Desktop.getDesktop().browse(new URI(TELEGRAM_LINK));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                
                // Проверяем клик по второй пасхалке (R)
                if (showSecondEasterEgg && 
                    e.getX() >= 20 && e.getX() <= 60 &&
                    e.getY() >= panel.getHeight() - 40 && e.getY() <= panel.getHeight() - 10) {
                    try {
                        Desktop.getDesktop().browse(new URI(SECOND_TELEGRAM_LINK));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Панель управления в стиле macOS
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        controlPanel.setOpaque(false);
        
        // Создаем кнопки в стиле macOS
        JButton closeButton = createMacButton(new Color(255, 95, 87));
        JButton minimizeButton = createMacButton(new Color(255, 189, 46));
        JButton zoomButton = createMacButton(new Color(39, 201, 63));
        
        // Добавляем обработчики событий
        closeButton.addActionListener(e -> System.exit(0));
        minimizeButton.addActionListener(e -> frame.setState(Frame.ICONIFIED));
        zoomButton.addActionListener(e -> {
            if (frame.getExtendedState() == Frame.MAXIMIZED_BOTH) {
                frame.setExtendedState(Frame.NORMAL);
            } else {
                frame.setExtendedState(Frame.MAXIMIZED_BOTH);
            }
        });
        
        // Добавляем кнопки на панель
        controlPanel.add(closeButton);
        controlPanel.add(minimizeButton);
        controlPanel.add(zoomButton);
        
        // Центральная панель с текстом
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        
        // Создаем метки для вывода текста
        JLabel label1 = new JLabel("Лиза обними меня и пошли пить чай");
        JLabel label2 = new JLabel("Я изучаю Java версии 17");
        
        // Пример простых вычислений
        int a = 5;
        int b = 3;
        int sum = a + b;
        JLabel label3 = new JLabel(a + " + " + b + " = " + sum);
        
        // Настраиваем шрифт и стиль
        Font mainFont = new Font("SF Pro Display", Font.PLAIN, 24);
        Font secondaryFont = new Font("SF Pro Text", Font.PLAIN, 18);
        
        label1.setFont(mainFont);
        label2.setFont(secondaryFont);
        label3.setFont(secondaryFont);
        
        Color textColor = new Color(240, 240, 240);
        label1.setForeground(textColor);
        label2.setForeground(textColor);
        label3.setForeground(textColor);
        
        // Делаем слово "Лиза" кликабельным
        label1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (puzzleAttempts < 3) {
                    // Создаем кастомный диалог
                    JDialog riddleDialog = new JDialog(frame, "Загадка", true);
                    riddleDialog.setUndecorated(true);
                    riddleDialog.setSize(500, 400);
                    riddleDialog.setLocationRelativeTo(frame);
                    riddleDialog.setBackground(new Color(0, 0, 0, 0));
                    
                    // Создаем панель с эффектом матового стекла
                    JPanel dialogPanel = new JPanel() {
                        @Override
                        protected void paintComponent(Graphics g) {
                            Graphics2D g2d = (Graphics2D) g;
                            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                            
                            // Используем точно такие же параметры как в основном окне
                            Color darkGlass = new Color(30, 30, 30, 150);
                            g2d.setColor(darkGlass);
                            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                        }
                    };
                    dialogPanel.setLayout(new BorderLayout());
                    dialogPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                    dialogPanel.setOpaque(false);
                    
                    // Панель управления в стиле macOS
                    JPanel dialogControlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
                    dialogControlPanel.setOpaque(false);
                    
                    JButton dialogCloseButton = createMacButton(new Color(255, 95, 87));
                    dialogCloseButton.addActionListener(e2 -> riddleDialog.dispose());
                    
                    dialogControlPanel.add(dialogCloseButton);
                    
                    // Текст загадки
                    JTextArea riddleText = new JTextArea(
                        "Разгадайте загадку:\n\n" +
                        "Между двух сердец я рождаюсь,\n" +
                        "В тихих взглядах я таюсь.\n" +
                        "Я могу быть сладкой как мед,\n" +
                        "Или горькой как полынь.\n" +
                        "Я невидима, но я сильна,\n" +
                        "Я могу быть вечной, как звезда,\n" +
                        "Или мимолетной, как роса.\n" +
                        "Я в каждом сердце, в каждой душе,\n" +
                        "Но не каждый меня найдет в тиши.\n\n" +
                        "Что я такое?"
                    );
                    riddleText.setFont(new Font("SF Pro Display", Font.PLAIN, 18));
                    riddleText.setForeground(new Color(240, 240, 240));
                    riddleText.setBackground(new Color(0, 0, 0, 0));
                    riddleText.setEditable(false);
                    riddleText.setLineWrap(true);
                    riddleText.setWrapStyleWord(true);
                    riddleText.setMargin(new Insets(10, 10, 10, 10));
                    
                    // Панель для ввода ответа
                    JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    inputPanel.setOpaque(false);
                    
                    // Создаем полупрозрачное поле ввода
                    JTextField answerField = new JTextField(20) {
                        @Override
                        protected void paintComponent(Graphics g) {
                            Graphics2D g2d = (Graphics2D) g;
                            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                            
                            // Полупрозрачный фон
                            g2d.setColor(new Color(60, 60, 60, 150));
                            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                            
                            // Рисуем текст
                            g2d.setColor(getForeground());
                            FontMetrics fm = g2d.getFontMetrics();
                            int textY = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
                            g2d.drawString(getText(), 5, textY);
                            
                            // Рисуем курсор если поле в фокусе
                            if (isFocusOwner()) {
                                int cursorX = fm.stringWidth(getText().substring(0, getCaretPosition())) + 5;
                                g2d.setColor(getForeground());
                                g2d.drawLine(cursorX, 5, cursorX, getHeight() - 5);
                            }
                        }
                    };
                    answerField.setFont(new Font("SF Pro Text", Font.PLAIN, 16));
                    answerField.setForeground(new Color(240, 240, 240));
                    answerField.setCaretColor(new Color(240, 240, 240));
                    answerField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                    answerField.setOpaque(false);
                    
                    // Создаем полупрозрачную кнопку
                    JButton submitButton = new JButton("Ответить") {
                        @Override
                        protected void paintComponent(Graphics g) {
                            Graphics2D g2d = (Graphics2D) g;
                            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                            
                            // Полупрозрачный фон
                            g2d.setColor(new Color(60, 60, 60, 150));
                            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                            
                            // Рисуем текст
                            g2d.setColor(getForeground());
                            FontMetrics fm = g2d.getFontMetrics();
                            int textX = (getWidth() - fm.stringWidth(getText())) / 2;
                            int textY = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
                            g2d.drawString(getText(), textX, textY);
                            
                            // Эффект при наведении
                            if (getModel().isRollover()) {
                                g2d.setColor(new Color(255, 255, 255, 30));
                                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                            }
                        }
                    };
                    submitButton.setFont(new Font("SF Pro Text", Font.PLAIN, 14));
                    submitButton.setForeground(new Color(240, 240, 240));
                    submitButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
                    submitButton.setContentAreaFilled(false);
                    submitButton.setFocusPainted(false);
                    submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    
                    inputPanel.add(answerField);
                    inputPanel.add(Box.createHorizontalStrut(10));
                    inputPanel.add(submitButton);
                    
                    // Добавляем обработчик для кнопки и поля ввода
                    ActionListener submitAction = e2 -> {
                        String answer = answerField.getText().trim().toLowerCase();
                        if (answer.equals("любовь")) {
                            showSecondEasterEgg = true;
                            panel.repaint();
                            JOptionPane.showMessageDialog(frame,
                                "Правильно! Вторая пасхалка разблокирована!",
                                "Успех!",
                                JOptionPane.INFORMATION_MESSAGE);
                            riddleDialog.dispose();
                        } else {
                            puzzleAttempts++;
                            String hint = "";
                            if (puzzleAttempts == 1) {
                                hint = "\n\nПодсказка: Это чувство, которое связывает два сердца.";
                            } else if (puzzleAttempts == 2) {
                                hint = "\n\nПодсказка: Это то, что делает мир прекраснее и теплее.";
                            }
                            JOptionPane.showMessageDialog(riddleDialog,
                                "Неправильно! Попыток осталось: " + (3 - puzzleAttempts) + hint,
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE);
                            if (puzzleAttempts >= 3) {
                                JOptionPane.showMessageDialog(riddleDialog,
                                    "У вас закончились попытки!\n" +
                                    "Правильный ответ: любовь",
                                    "Конец игры",
                                    JOptionPane.WARNING_MESSAGE);
                                riddleDialog.dispose();
                            }
                        }
                    };
                    
                    submitButton.addActionListener(submitAction);
                    answerField.addActionListener(submitAction);
                    
                    // Добавляем возможность перетаскивания диалога
                    final Point[] dialogMouseOffset = new Point[1];
                    dialogPanel.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            dialogMouseOffset[0] = e.getPoint();
                        }
                    });
                    
                    dialogPanel.addMouseMotionListener(new MouseMotionAdapter() {
                        public void mouseDragged(MouseEvent e) {
                            if (dialogMouseOffset[0] != null) {
                                Point newLocation = e.getLocationOnScreen();
                                newLocation.translate(-dialogMouseOffset[0].x, -dialogMouseOffset[0].y);
                                riddleDialog.setLocation(newLocation);
                            }
                        }
                    });
                    
                    // Собираем диалог
                    dialogPanel.add(dialogControlPanel, BorderLayout.NORTH);
                    dialogPanel.add(riddleText, BorderLayout.CENTER);
                    dialogPanel.add(inputPanel, BorderLayout.SOUTH);
                    
                    riddleDialog.add(dialogPanel);
                    riddleDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frame,
                        "У вас закончились попытки!\n" +
                        "Правильный ответ: любовь",
                        "Конец игры",
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // Центрируем текст
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Добавляем отступы между элементами
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(label1);
        centerPanel.add(Box.createVerticalStrut(30));
        centerPanel.add(label2);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(label3);
        centerPanel.add(Box.createVerticalGlue());
        
        // Добавляем возможность перетаскивания окна
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseOffset = e.getPoint();
            }
        });
        
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (mouseOffset != null) {
                    Point newLocation = e.getLocationOnScreen();
                    newLocation.translate(-mouseOffset.x, -mouseOffset.y);
                    frame.setLocation(newLocation);
                }
            }
        });
        
        // Добавляем компоненты на основную панель
        panel.add(controlPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    private static JButton createMacButton(Color color) {
        JButton button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Рисуем круглую кнопку
                g2d.setColor(color);
                g2d.fillOval(0, 0, getWidth(), getHeight());
                
                // Добавляем эффект при наведении
                if (getModel().isRollover()) {
                    g2d.setColor(new Color(0, 0, 0, 30));
                    g2d.fillOval(0, 0, getWidth(), getHeight());
                }
            }
        };
        
        button.setPreferredSize(new Dimension(12, 12));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        return button;
    }
} 