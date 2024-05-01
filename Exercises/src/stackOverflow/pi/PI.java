package stackOverflow.pi;

public class PI implements Runnable {
	private float PI = 0;
	private long Time;
	private boolean StopCalculation = false;
	private Thread thread;

	PI(String name) {
		thread = new Thread(this, name);
		thread.start();
	}

	@Override
	public void run() {
		for (int i = 0;; i++) {
			synchronized (thread) {
				long TMP = System.currentTimeMillis();
				PI = PI + ((float) (Math.pow(-1, i) * (1.0 / (2 * i + 1))));
				Time += System.currentTimeMillis() - TMP;
				while (StopCalculation)
					try {
						thread.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}
	}

	public long getTime() {
		return Time;
	}

	public float getPI() {
		return PI;
	}

	public void setStopProcess(boolean stopProcess) {
		StopCalculation = stopProcess;
	}
}