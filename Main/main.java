
package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class main extends javax.swing.JFrame {
    private Animator animatorLogin;
    private Animator animatorBody;
    private boolean signIn;

    public main() {
        initComponents();
        setTitle("LOGIN INTERFACE");
        setIconImage(new ImageIcon("C:\\Java\\icon\\Login-image.png").getImage());
        getContentPane().setBackground(new Color(255,255,255));
        TimingTarget targetLogin = new TimingTargetAdapter()
                {
            @Override
            public void timingEvent(float fraction) {
                if(signIn)
                {
                     backGroundMain.setAnimate(fraction); // signIn =true thì login, animate đi lên
                     
                }
                else
                {
                     backGroundMain.setAnimate(1f-fraction); // false thì đi xuống
                }
           
            }

            @Override
            public void end() {
                if(signIn)
                {
                paneLogin.setVisible(false); // tắt màn hình login
                backGroundMain.setShowpaint(true);
                panelBody.setAlpha(0); //set transparent to 0 sau đó tăng lên để làm hiệu ứng chuyển tab
                panelBody.setVisible(true); // mở màn hình giao diện chính
                animatorBody.start();
                } else
                {
                    username.grabFocus();
                }
               
             
            }
 
            };
        TimingTarget targetBody = new TimingTargetAdapter()
                {
            @Override
            public void timingEvent(float fraction) {
               if(signIn)
                    panelBody.setAlpha(fraction); // hiệu ứng mờ
               else
                   panelBody.setAlpha(1f-fraction); // đảo ngược nếu sign out
            }

            @Override
            public void end() 
            {
              if(signIn==false) // quay lại màn hình Login
                {
                    panelBody.setVisible(false); // kết thúc màn hình hiện tại
                    backGroundMain.setShowpaint(false); // 
                    backGroundMain.setAnimate(1); //set animate 
                    animatorLogin.start(); // bắt đầu animate, nếu signIn true, animate đi lên, không thì đi xuống
                    paneLogin.setVisible(true); // mở màn hình login
                }
            }
 
            };
        animatorLogin = new Animator(800,targetLogin); // set thời gian chuyển side, thay đổi con số để điều chỉnh tốc độ
        animatorBody= new Animator(800,targetBody);
        animatorLogin.setResolution(0); // độ phân giải cao, không bị mờ
        animatorBody.setResolution(0); // độ phân giải cao, không bị mờ
        jScrollPane1.getViewport().setOpaque(false);
        
       
    }
        
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backGroundMain = new Swing.BackGround();
        paneLogin = new javax.swing.JPanel();
        Login = new javax.swing.JPanel();
        username = new com.raven.swing.TextField();
        password = new com.raven.swing.PasswordField();
        signInButton = new com.raven.swing.Button();
        passInvisible = new javax.swing.JLabel();
        userIcon = new javax.swing.JLabel();
        imageAvatar1 = new com.raven.swing.ImageAvatar();
        exitLogin = new javax.swing.JLabel();
        panelBody = new com.raven.swing.PanelTransparent();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        slidebar = new javax.swing.JPanel();
        thongKeButton = new com.raven.swing.Button();
        chinhSua = new com.raven.swing.Button();
        signOut = new javax.swing.JLabel();
        exitBody = new javax.swing.JLabel();
        searchText = new com.raven.swing.TextField();
        searchIcon = new javax.swing.JLabel();
        imageAvatar2 = new com.raven.swing.ImageAvatar();
        Education = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        backGroundMain.setLayout(new java.awt.CardLayout());

        paneLogin.setOpaque(false);

        Login.setBackground(new java.awt.Color(255, 255, 255));

        username.setLabelText(" User Name");
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
        });

        password.setLabelText("Password");
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        signInButton.setBackground(new java.awt.Color(102, 194, 255));
        signInButton.setForeground(new java.awt.Color(255, 255, 255));
        signInButton.setText("SIGN IN");
        signInButton.setEffectColor(new java.awt.Color(152, 221, 238));
        signInButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        passInvisible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passInvisible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Invisible.png"))); // NOI18N

        userIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/User Male_2.png"))); // NOI18N

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(userIcon))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passInvisible, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(userIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(passInvisible)))
                .addGap(65, 65, 65)
                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        imageAvatar1.setBackground(new java.awt.Color(255, 255, 255));
        imageAvatar1.setBorderSize(4);
        imageAvatar1.setBorderSpace(1);
        imageAvatar1.setGradientColor1(new java.awt.Color(102, 194, 255));
        imageAvatar1.setGradientColor2(new java.awt.Color(102, 194, 255));
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icon/Mobile login-rafiki.png"))); // NOI18N

        exitLogin.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        exitLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitLogin.setText("X");
        exitLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitLoginMouseExited(evt);
            }
        });

        javax.swing.GroupLayout paneLoginLayout = new javax.swing.GroupLayout(paneLogin);
        paneLogin.setLayout(paneLoginLayout);
        paneLoginLayout.setHorizontalGroup(
            paneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneLoginLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitLogin)
                .addContainerGap())
        );
        paneLoginLayout.setVerticalGroup(
            paneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLoginLayout.createSequentialGroup()
                .addComponent(exitLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addGroup(paneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(218, Short.MAX_VALUE))
        );

        backGroundMain.add(paneLogin, "card2");

        panelBody.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 0, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Họ và tên", "Số báo danh", "Môn A", "Môn B", "Môn C", "Khối thi", "Điểm trung bình"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setDragEnabled(true);
        jTable1.setFillsViewportHeight(true);
        jTable1.setFocusCycleRoot(true);
        jTable1.setShowGrid(true);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(jTable1);

        slidebar.setBackground(new java.awt.Color(102, 193, 255));

        thongKeButton.setBackground(new java.awt.Color(104, 194, 255));
        thongKeButton.setForeground(new java.awt.Color(255, 255, 255));
        thongKeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/statis.png"))); // NOI18N
        thongKeButton.setText("Thống Kê");
        thongKeButton.setEffectColor(new java.awt.Color(26, 255, 255));
        thongKeButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        thongKeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thongKeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                thongKeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                thongKeButtonMouseExited(evt);
            }
        });
        thongKeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongKeButtonActionPerformed(evt);
            }
        });

        chinhSua.setBackground(new java.awt.Color(104, 194, 255));
        chinhSua.setForeground(new java.awt.Color(255, 255, 255));
        chinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tools_3.png"))); // NOI18N
        chinhSua.setText("Chỉnh Sửa");
        chinhSua.setEffectColor(new java.awt.Color(26, 255, 255));
        chinhSua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        chinhSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chinhSuaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chinhSuaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                chinhSuaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chinhSuaMousePressed(evt);
            }
        });
        chinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chinhSuaActionPerformed(evt);
            }
        });

        signOut.setBackground(new java.awt.Color(105, 194, 255));
        signOut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signOut.setForeground(new java.awt.Color(255, 255, 255));
        signOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Logout Rounded.png"))); // NOI18N
        signOut.setText("SIGN OUT");
        signOut.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        signOut.setMaximumSize(new java.awt.Dimension(200, 200));
        signOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signOutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout slidebarLayout = new javax.swing.GroupLayout(slidebar);
        slidebar.setLayout(slidebarLayout);
        slidebarLayout.setHorizontalGroup(
            slidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(thongKeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(slidebarLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(signOut, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(slidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(chinhSua, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
        );
        slidebarLayout.setVerticalGroup(
            slidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slidebarLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(thongKeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(slidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(slidebarLayout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addComponent(chinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(492, Short.MAX_VALUE)))
        );

        exitBody.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        exitBody.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitBody.setText("X");
        exitBody.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBodyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitBodyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitBodyMouseExited(evt);
            }
        });

        searchText.setForeground(new java.awt.Color(0, 204, 255));
        searchText.setToolTipText("Tìm kiếm");
        searchText.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        searchText.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        searchText.setLabelText("");
        searchText.setLineColor(new java.awt.Color(0, 204, 255));
        searchText.setSelectedTextColor(new java.awt.Color(0, 204, 255));
        searchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextActionPerformed(evt);
            }
        });

        searchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search_2.png"))); // NOI18N

        imageAvatar2.setBorderSize(3);
        imageAvatar2.setBorderSpace(1);
        imageAvatar2.setGradientColor1(new java.awt.Color(255, 255, 255));
        imageAvatar2.setGradientColor2(new java.awt.Color(255, 255, 255));
        imageAvatar2.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icon/education-image.jpg"))); // NOI18N

        Education.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Education.setForeground(new java.awt.Color(255, 255, 255));
        Education.setText("Education");

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addComponent(slidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1))
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Education, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(searchIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202)
                .addComponent(exitBody)
                .addContainerGap())
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBodyLayout.createSequentialGroup()
                        .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Education, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(exitBody)))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                    .addComponent(slidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        backGroundMain.add(panelBody, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backGroundMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backGroundMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
//    int widthSlideBar=238;
//    int heightSlideBar= 647;
//    public void openSlideBar()
//    {
//                         
//           
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                      for(int i=0;i <widthSlideBar;i++)
//                          SlideBar.setSize(i,heightSlideBar);
//                    }
//
//                }).start();
//
//    }
//
//    public void closeSlideBar()
//    {
//           new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        for(int i=widthSlideBar; i>0;i--)
//                            SlideBar.setSize(i,heightSlideBar);
//                    }
//
//                }).start();
//            
//    }
  
    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        
        if(!animatorLogin.isRunning())
        {
            signIn=true;
            String user= username.getText();
            String pass= password.getText();
            boolean action=true;
            if(user.equals(""))
            {
                username.setHelperText("Please input user name!");
                username.grabFocus();//  grabfocus bắt người dùng tương tác với nó mà không cần nhấp chuột
                action=false;
            }
            if(pass.equals(""))
            {
                password.setHelperText("Please input password!");
                if(action) // nếu tài khoản đã được nhập ( chưa biết đúng sai) thì mật khẩu bắt buộc phải nhập chứ không để trống
                    password.grabFocus();
                action=false;
            }
            
             if(action&& ((pass.equals("khang113") && user.equals("Khangchau")) || (user.equals("Nguyenhao") && pass.equals("hao88"))))
             {
                
                animatorLogin.start();
             }
             else 
             {
                 JOptionPane.showMessageDialog(rootPane, "Tài khoản hoặc mật khẩu sai! ");
             }
           
        }
       
    }//GEN-LAST:event_signInButtonActionPerformed

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        signIn=true;    
        String user= username.getText();
        String pass= password.getText();
        boolean action=true;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
             if(user.equals(""))
        {
            username.setHelperText("Please input user name!");
            username.grabFocus();//  grabfocus bắt người dùng tương tác với nó mà không cần nhấp chuột
            action=false;
        }
        if(pass.equals(""))
        {
            password.setHelperText("Please input password!");
            if(action) // nếu tài khoản đã được nhập ( chưa biết đúng sai) thì mật khẩu bắt buộc phải nhập chứ không để trống
                password.grabFocus();
            action=false;
        }

         if(action && (pass.equals("khang113") && user.equals("Khangchau")) || (user.equals("Nguyenhao") && pass.equals("hao88")))
         {

            animatorLogin.start();
         }
         else 
         {
             JOptionPane.showMessageDialog(rootPane, "Tài khoản hoặc mật khẩu sai! ");
             username.grabFocus();
         }
        }
          
    }//GEN-LAST:event_usernameKeyPressed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        signIn=true;
        String user= username.getText();
        String pass= password.getText();
        boolean action=true;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
              if(user.equals(""))
        {
            username.setHelperText("Please input user name!");
            username.grabFocus();//  grabfocus bắt người dùng tương tác với nó mà không cần nhấp chuột
            action=false;
        }
        if(pass.equals(""))
        {
            password.setHelperText("Please input password!");
            if(action) // nếu tài khoản đã được nhập ( chưa biết đúng sai) thì mật khẩu bắt buộc phải nhập chứ không để trống
                password.grabFocus();
            action=false;
        }

         if(action&& ((pass.equals("khang113") && user.equals("Khangchau")) || (user.equals("Nguyenhao") && pass.equals("hao88"))))
         {

            animatorLogin.start();
         }
         else 
         {
             JOptionPane.showMessageDialog(rootPane, "Tài khoản hoặc mật khẩu sai! ");
             password.grabFocus();
         }
        }
          
    }//GEN-LAST:event_passwordKeyPressed

    private void thongKeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongKeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thongKeButtonActionPerformed

    private void chinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chinhSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chinhSuaActionPerformed

    private void signOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutMouseEntered
        signOut.setForeground(new Color(102, 217, 255));
    }//GEN-LAST:event_signOutMouseEntered

    private void signOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutMouseExited
        signOut.setForeground(Color.white);
    }//GEN-LAST:event_signOutMouseExited

    private void signOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutMouseClicked
        signIn=false;
        animatorBody.start();
        username.setText("");
        password.setText("");
    }//GEN-LAST:event_signOutMouseClicked

    private void searchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextActionPerformed

    private void chinhSuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chinhSuaMouseEntered
        // TODO add your handling code here:
        chinhSua.setBackground(new Color(102, 217, 255));
         chinhSua.setForeground(Color.white);
    }//GEN-LAST:event_chinhSuaMouseEntered

    private void chinhSuaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chinhSuaMouseExited
        // TODO add your handling code here:
        chinhSua.setBackground(new Color(104,194,255));
        chinhSua.setForeground(Color.white);
    }//GEN-LAST:event_chinhSuaMouseExited

    private void thongKeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongKeButtonMouseEntered
        // TODO add your handling code here:
        thongKeButton.setBackground(new Color(102, 217, 255));
        thongKeButton.setForeground(Color.white);
    }//GEN-LAST:event_thongKeButtonMouseEntered

    private void thongKeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongKeButtonMouseExited
        // TODO add your handling code here:
        thongKeButton.setBackground(new Color(104,194,255));
        thongKeButton.setForeground(Color.white);
    }//GEN-LAST:event_thongKeButtonMouseExited

    private void exitLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLoginMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitLoginMouseClicked

    private void exitLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLoginMouseEntered
        exitLogin.setForeground(new Color(104,194,255));
    }//GEN-LAST:event_exitLoginMouseEntered

    private void exitLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLoginMouseExited
        exitLogin.setForeground(Color.black);
    }//GEN-LAST:event_exitLoginMouseExited

    private void exitBodyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBodyMouseClicked
      System.exit(0);
    }//GEN-LAST:event_exitBodyMouseClicked

    private void exitBodyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBodyMouseEntered
         exitBody.setForeground(Color.white);
    }//GEN-LAST:event_exitBodyMouseEntered

    private void exitBodyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBodyMouseExited
        exitBody.setForeground(Color.black);
    }//GEN-LAST:event_exitBodyMouseExited

    private void thongKeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongKeButtonMouseClicked
        ThongKe thongke = new ThongKe();
        thongke.setVisible(true);
        thongKeButton.setBackground(new Color(157, 70, 243));
        dispose();
    }//GEN-LAST:event_thongKeButtonMouseClicked

    private void chinhSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chinhSuaMouseClicked
        ChinhSua chinhsua = new ChinhSua();
        chinhsua.setVisible(true);
        dispose();
    }//GEN-LAST:event_chinhSuaMouseClicked

    private void chinhSuaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chinhSuaMousePressed
        ChinhSua chinhsua = new ChinhSua();
        chinhsua.setVisible(true);
        chinhSua.setBackground(Color.red);
        dispose();
    }//GEN-LAST:event_chinhSuaMousePressed

   
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Education;
    private javax.swing.JPanel Login;
    private Swing.BackGround backGroundMain;
    private com.raven.swing.Button chinhSua;
    private javax.swing.JLabel exitBody;
    private javax.swing.JLabel exitLogin;
    private com.raven.swing.ImageAvatar imageAvatar1;
    private com.raven.swing.ImageAvatar imageAvatar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel paneLogin;
    private com.raven.swing.PanelTransparent panelBody;
    private javax.swing.JLabel passInvisible;
    private com.raven.swing.PasswordField password;
    private javax.swing.JLabel searchIcon;
    private com.raven.swing.TextField searchText;
    private com.raven.swing.Button signInButton;
    private javax.swing.JLabel signOut;
    private javax.swing.JPanel slidebar;
    private com.raven.swing.Button thongKeButton;
    private javax.swing.JLabel userIcon;
    private com.raven.swing.TextField username;
    // End of variables declaration//GEN-END:variables
}
