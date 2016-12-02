package mx.edu.itsm.msc.jadecontainer;
public class CondVar {
	private boolean value = false;

	public synchronized void waitOn() throws InterruptedException {
		while(!value) {
			wait();
		}
	}

	public synchronized void signal() {
		value = true;
		notifyAll();
	}

} // End of CondVar class