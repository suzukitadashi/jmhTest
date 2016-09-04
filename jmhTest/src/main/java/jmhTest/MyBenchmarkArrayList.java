package jmhTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
public class MyBenchmarkArrayList {

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(MyBenchmarkArrayList.class.getSimpleName()).warmupIterations(5)
				.measurementIterations(5).forks(2).build();
		new Runner(opt).run();
	}

	@Benchmark
	public void test1Clear() {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				list.add(j);
			}
			list.clear();
		}

	}

	@Benchmark
	public void test2New() {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				list.add(j);
			}
			list = new ArrayList<>();
		}

	}

	@Benchmark
	public void test3ClearWithInitialCapacity() {

		List<Integer> list = new ArrayList<>(1000);

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				list.add(j);
			}
			list.clear();
		}

	}

	@Benchmark
	public void test4NewWithInitialCapacity() {

		List<Integer> list = new ArrayList<>(1000);

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				list.add(j);
			}
			list = new ArrayList<>(1000);
		}

	}

}
