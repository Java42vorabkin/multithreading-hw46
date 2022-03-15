package telran.messaging.hw46;

public class Reciever extends Thread {

	MessageBox messageBox;

	public Reciever(MessageBox messageBox) {
		this.messageBox = messageBox;
		//TODO update code - no daemon. done
//		setDaemon(true);
	}
	@Override
	public void run() {
		String message = null;
		while(true) {
			try {
				message = messageBox.getText();
				System.out.printf("%s - %s\n", getName(), message);
			} catch (InterruptedException e) {
				// TODO done
				while(messageBox.pullText() != null) {
					System.out.printf("%s - %s\n", getName(), message);
				}
				break;
			}
		}
	}
}
