package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;

public class DialogQueSeFecha implements Runnable, ActionListener
{
    private JDialog dialog;

    public DialogQueSeFecha(JDialog dialog)
    {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        dialog.dispose();
    }    

    // EDIT: in response to comment
    static public void showMessageDialog(Component parent, Object message) {
      // run all of this on the EDT
      final JOptionPane optionPane = new JOptionPane(message);
      String title = UIManager.getString("OptionPane.messageDialogTitle");
      final JDialog dialog = optionPane.createDialog(parent, title);
      Timer timer = new Timer(5000, new DialogQueSeFecha(dialog));
      timer.setRepeats(false);
      timer.start();
      if (dialog.isDisplayable())
          dialog.setVisible(true);
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[])
	{
		DialogQueSeFecha autoDiS = new DialogQueSeFecha(new JDialog());
		autoDiS.showMessageDialog(null, "ok");
		
	}
}
