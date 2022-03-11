package telran.games.hw46;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
	private final int WINID_INITIAL = -1;
	private int winnerId = WINID_INITIAL;
	private AtomicInteger atomicWinner = new AtomicInteger(WINID_INITIAL);
	private List<Runner> resultsTable;
	private Instant startTime;
	
	public List<Runner> getResultsTable() {
		return resultsTable;
	}
	public Instant getStartTime() {
		return startTime;
	}
	public Race(int distance, int minSleep, int maxSleep, List<Runner> resultsTable, Instant startTime) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
		this.resultsTable = resultsTable;
		this.startTime = startTime;
	}
	public int getWinner() {
		return winnerId;
	}
	public int getAtomicWinner() {
		return atomicWinner.get();
	}
	public void setWinner(int winnerId) {
		if (this.winnerId == WINID_INITIAL) {
			this.winnerId = winnerId;
		}
	}
	public void setAtomicWinner(int winnerId) {
		atomicWinner.compareAndSet(WINID_INITIAL, winnerId);
	}
	public int getDistance() {
		return distance;
	}
	public int getMinSleep() {
		return minSleep;
	}
	public int getMaxSleep() {
		return maxSleep;
	}
}
