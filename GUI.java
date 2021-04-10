import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;
import java.io.DataOutputStream;
import java.lang.Thread;

public class GUI{
    public static void main(String args[]){
        JFrame container=new JFrame("Bryce's GUI");
        container.setSize(400, 400);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setLocationRelativeTo(null);
        Socket spyderSock;
        Socket gitSock;
        Socket orangeSock;
        Socket hadoopSock;
        Socket sparkSock;
        Socket tfSock;
        Socket tableauSock;
        Socket sonarSock;
        DataOutputStream gitOut=null;
        DataOutputStream spyderOut=null;
        DataOutputStream orangeOut=null;
        DataOutputStream hadoopOut=null;
        DataOutputStream sparkOut=null;
        DataOutputStream tfOut=null;
        DataOutputStream tableauOut=null;
        DataOutputStream sonarOut=null;
        try{
            Thread.sleep(2000); //This is so the containers have the chance to get the sockets opened, I was having issues before with the sockets connecting prematurely and failing.
        } catch(Exception e){
            System.out.println(e);
        }
        try{
            spyderSock=new Socket("spyder", 8090);
            spyderOut=new DataOutputStream(spyderSock.getOutputStream());

            gitSock=new Socket("git", 8100);
            gitOut=new DataOutputStream(gitSock.getOutputStream());

            orangeSock=new Socket("orange", 8300);
            orangeOut=new DataOutputStream(orangeSock.getOutputStream());

            hadoopSock=new Socket("hadoop", 8400);
            hadoopOut=new DataOutputStream(hadoopSock.getOutputStream());

            sparkSock=new Socket("spark", 8500);
            sparkOut=new DataOutputStream(sparkSock.getOutputStream());

            tfSock=new Socket("tensorflow", 8600);
            tfOut=new DataOutputStream(tfSock.getOutputStream());

            tableauSock=new Socket("tableau", 8850);
            tableauOut=new DataOutputStream(tableauSock.getOutputStream());

            sonarSock=new Socket("sonar", 8700);
            sonarOut=new DataOutputStream(sonarSock.getOutputStream());
        }
        catch(Exception e){
            System.out.println(e);
        }
        // Rstudio
        JButton rstudio = new JButton("RStudio");
        ActionListener rlistener=new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                try{
                    Process p = Runtime.getRuntime().exec("firefox rstudio:8787");
                } catch(IOException exec){
                    System.out.println(exec);
                }
            }
        };
        rstudio.addActionListener(rlistener);
        
        
        // Spyder
        JButton spyder = new JButton("Spyder");
        spyder.putClientProperty("out", spyderOut);
        ActionListener spylistener=new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                try{
                    ((DataOutputStream)((JButton)e.getSource()).getClientProperty("out")).writeUTF("spyder"); //This pulls the DataOutputStream out of the JButton and sends the command to the listener in the other Docker container
                } catch(Exception exec){
                    System.out.println(exec);
                }
            }
        };
        spyder.addActionListener(spylistener);


        //SAS
        JButton sas = new JButton("SAS");
        ActionListener saslistener=new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                try{
                    Process p = Runtime.getRuntime().exec("firefox sas:38080/SASStudio");
                } catch(IOException exec){
                    System.out.println(exec);
                }
            }
        };
        sas.addActionListener(saslistener);
        

        //Git
        JButton git = new JButton("Git");
        git.putClientProperty("out", gitOut);
        ActionListener gitlistener=new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                try{
                    ((DataOutputStream)((JButton)e.getSource()).getClientProperty("out")).writeUTF("xterm"); //This pulls the DataOutputStream out of the JButton and sends the command to the listener in the other Docker container
                } catch(Exception exec){
                    System.out.println(exec);
                }
            }
        };
        git.addActionListener(gitlistener);

        //Jupyter
        JButton jupyter = new JButton("Jupyter");
        ActionListener jupyterlistener=new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                try{
                    Process p = Runtime.getRuntime().exec("firefox jupyter:8888");
                } catch(IOException exec){
                    System.out.println(exec);
                }
            }
        };
        jupyter.addActionListener(jupyterlistener);


        //Orange
        JButton orange = new JButton("Orange");
        orange.putClientProperty("out", orangeOut);
        ActionListener orangelistener=new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                try{
                    ((DataOutputStream)((JButton)e.getSource()).getClientProperty("out")).writeUTF("orange-canvas"); //This pulls the DataOutputStream out of the JButton and sends the command to the listener in the other Docker container
                } catch(Exception exec){
                    System.out.println(exec);
                }
            }
        };
        orange.addActionListener(orangelistener);

        //VSCode
        JButton vscode = new JButton("Visual Studio Code");
        ActionListener vscodelistener=new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                try{
                    Process p = Runtime.getRuntime().exec("firefox vscode:8080");
                } catch(IOException exec){
                    System.out.println(exec);
                }
            }
        };
        vscode.addActionListener(vscodelistener);

        //Hadoop
        JButton hadoop = new JButton("Hadoop");
        hadoop.putClientProperty("out", hadoopOut);
        ActionListener hadooplistener=new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                try{
                    ((DataOutputStream)((JButton)e.getSource()).getClientProperty("out")).writeUTF("xterm"); //This pulls the DataOutputStream out of the JButton and sends the command to the listener in the other Docker container
                } catch(Exception exec){
                    System.out.println(exec);
                }
            }
        };
        hadoop.addActionListener(hadooplistener);

        //Spark
        JButton spark = new JButton("Spark");
        spark.putClientProperty("out", sparkOut);
        ActionListener sparklistener=new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                try{
                    ((DataOutputStream)((JButton)e.getSource()).getClientProperty("out")).writeUTF("xterm"); //This pulls the DataOutputStream out of the JButton and sends the command to the listener in the other Docker container
                } catch(Exception exec){
                    System.out.println(exec);
                }
            }
        };
        spark.addActionListener(sparklistener);


        //Tableau
        JButton tableau = new JButton("Tableau");
        tableau.putClientProperty("out", tableauOut);
        ActionListener tableaulistener=new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                try{
                    ((DataOutputStream)((JButton)e.getSource()).getClientProperty("out")).writeUTF("firefox https://sso.online.tableau.com/public/idp/SSO"); //This pulls the DataOutputStream out of the JButton and sends the command to the listener in the other Docker container
                } catch(IOException exec){
                    System.out.println(exec);
                }
            }
        };
        tableau.addActionListener(tableaulistener);

        //TensorFlow
        JButton tf = new JButton("TensorFlow");
        tf.putClientProperty("out", tfOut);
        ActionListener tflistener=new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                try{
                    ((DataOutputStream)((JButton)e.getSource()).getClientProperty("out")).writeUTF("xterm"); //This pulls the DataOutputStream out of the JButton and sends the command to the listener in the other Docker container
                } catch(Exception exec){
                    System.out.println(exec);
                }
            }
        };
        tf.addActionListener(tflistener);


        //Markdown
        JButton markdown = new JButton("Markdown");
        ActionListener markdownlistener=new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                try{
                    Process p = Runtime.getRuntime().exec("firefox markdown:80");
                } catch(IOException exec){
                    System.out.println(exec);
                }
            }
        };
        markdown.addActionListener(markdownlistener);

        //SonarCloud
        JButton sonar = new JButton("SonarCloud");
        sonar.putClientProperty("out", sonarOut);
        ActionListener sonarlistener=new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                try{
                    ((DataOutputStream)((JButton)e.getSource()).getClientProperty("out")).writeUTF("firefox https://sonarcloud.io/sessions/new"); //This pulls the DataOutputStream out of the JButton and sends the command to the listener in the other Docker container
                } catch(IOException exec){
                    System.out.println(exec);
                }
            }
        };
        sonar.addActionListener(sonarlistener);

        JPanel panel = new JPanel();
        panel.add(rstudio);
        panel.add(spyder);
        panel.add(sas);
        panel.add(git);
        panel.add(jupyter);
        panel.add(orange);
        panel.add(vscode);
        panel.add(hadoop);
        panel.add(spark);
        panel.add(tableau);
        panel.add(sonar);
        panel.add(tf);
        panel.add(markdown);
        container.getContentPane().add(panel);
        container.setVisible(true);
    }
}

// https://security.stackexchange.com/questions/218355/how-to-execute-a-command-directly-on-the-host-system-through-docker-sock-in-a-do


/*
docker run -ti --privileged --net=host --pid=host --ipc=host --volume /:/host . chroot /host
camper484/autvarunspyderimg


def git():
        mySocket = socket( AF_INET, SOCK_STREAM )
        mySocket.connect(('git', 8090)) 
        mySocket.send(tmpstr.encode())


app:
    image: 
    environment:
      - DISPLAY=unix$DISPLAY
    expose:
      - "8000"
    volumes:
      - /tmp/.X11-unix:/tmp/.X11-unix


hadoop:
build: src/hadoop <- dockerfile containing a namenode/datanode cluster
environment:
- DISPLAY=${DISPLAY}
volumes:
- /tmp/.X11-unix:/tmp/.X11-unix
expose:
- "8080"

ENV JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/jre"
ENV PATH="${PATH}:/hadoop-3.3.0/bin"

or just try /bin/sh
RUN useradd -ms /bin/bash xterm


*/