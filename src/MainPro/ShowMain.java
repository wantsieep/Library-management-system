package MainPro;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Action;

import PublicModule.DbOp;

public class ShowMain extends Frame {
    private static final long serialVersionUID = 5003296786441785470L;
    MenuBar menuBar1;
    Menu menu1,menu2,menu3,menu4,menu5,menu6,menu7;
    MenuItem mi_book_add,mi_book_update,mi_book_delete,mi_reader_add,
             mi_reader_update,mi_reader_delete,mi_borrow,mi_back,
             mi_query_book,mi_query_reader,mi_update_pass,mi_exit;
    
    public void setRights(String rights){
        //如果不是管理员,则禁止用户维护图书信息和读者信息
        //以及禁止进行借阅管理
        if ( rights.equals("否") ){
            menu1.setEnabled(false);
            menu2.setEnabled(false);
        }
    }

    public ShowMain(){
        setTitle("图书管理系统");
        setLayout(new BorderLayout());
        setSize(640,480);
        menuBar1 = new MenuBar();
        menu5 = new Menu("基础维护");   //基础维护菜单

        menu6 = new Menu("图书维护");   //图书维护菜单
        mi_book_add = new MenuItem("添加");
        mi_book_update = new MenuItem("修改");
        mi_book_delete = new MenuItem("删除");

        menu7 = new Menu("读者维护");
        mi_reader_add = new MenuItem("添加读者");
        mi_reader_update = new MenuItem("修改读者");
        mi_reader_delete = new MenuItem("删除读者");
        
        menu1 = new Menu("借阅管理");
        mi_borrow = new MenuItem("借书管理");
        mi_back = new MenuItem("还书管理");

        menu2 = new Menu("查询管理");
        mi_query_book = new MenuItem("图书查询");
        mi_query_reader = new MenuItem("读者查询");

        menu3 = new Menu("系统管理");
        mi_update_pass = new MenuItem("修改密码");
        mi_exit = new MenuItem("退出系统");

        //添加图书菜单
        mi_book_add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new BookAdd();
            }
        });

        mi_book_update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new BookUpdate();
            }
        });

        mi_book_delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new BookDelete();
            }
        });

       /* mi_reader_add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ReaderAdd();
            }
        });

        mi_reader_update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ReaderUpdate();
            }
        });
	
        mi_reader_delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ReaderDelete();
            }
        });
		*/
         mi_borrow.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Borrow();
            }
        });
         
         mi_back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Back();
            }
        });
        
         mi_query_book.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new BookQuery();
            }
        });
         /*
         mi_query_reader.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ReaderQuery();
            }
        });

        mi_update_pass.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new UpdatePassword();
            }
        });
          */
        mi_exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DbOp.Close();
                System.exit(0);
            }
        });
		
        //关闭窗口
        this.addWindowFocusListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                DbOp.Close();
                System.exit(0);
            }
        });

        menu5.add(menu6);               menu6.add(mi_book_add);         menu6.add(mi_book_update);
        menu6.add(mi_book_delete);      menu5.add(menu7);               menu7.add(mi_reader_add);
        menu7.add(mi_reader_update);    menu7.add(mi_reader_delete);    menu5.add(menu1);
        menu1.add(mi_borrow);           menu1.add(mi_back);             menu5.add(menu2);
        menu2.add(mi_query_book);       menu2.add(mi_query_reader);     menu5.add(menu3);
        menu3.add(mi_update_pass);      menu3.add(mi_exit);             menuBar1.add(menu5);
        menuBar1.add(menu1);            menuBar1.add(menu2);            menuBar1.add(menu3);
        setMenuBar(menuBar1);

        setLocationRelativeTo(null);

        setVisible(true);

    }

    public static void main(String[] args) {
        new ShowMain();
    }

}