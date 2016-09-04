package jmhTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@BenchmarkMode(Mode.AverageTime)
public class MyBenchmarkForString {

	private List<String> strings = new ArrayList<>(count);
	private static final int count = 10000;

	@Setup
	public void init() {
		strings = new ArrayList<>(count);
		for (int i = 0; i < count; i++) {
			strings.add("[Str" + String.format("%1$03d", i) + "]");
		}
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(MyBenchmarkForString.class.getSimpleName()).warmupIterations(5)
				.measurementIterations(5).forks(2).build();
		new Runner(opt).run();

	}
	
	@Benchmark
	public void test1String() {
		concat1String(strings);
	}
	
	@Benchmark
	public void test2StringConcat() {
		concat2StringConcat(strings);
	}
	
	@Benchmark
	public void test3StringBufferConcat() {
		concat3StringBuffer(strings);
	}
	
	@Benchmark
	public void test4StringBuilder() {
		concat4StringBuilder(strings);
	}

	public String concat1String(List<String> strs) {
		String strings = "";
		for (String str : strs) {
			strings += str;
			strings += "\n";
		}
		return strings;
	}

	public String concat2StringConcat(List<String> strs) {
		String strings = "";
		for (String str : strs) {
			strings = strings.concat(str);
			strings = strings.concat("\n");
		}
		return strings;
	}


	public String concat3StringBuffer(List<String> strs) {
		StringBuffer strings = new StringBuffer();
		for (String str : strs) {
			strings.append(str);
			strings.append("\n");
		}
		return strings.toString();
	}


	public String concat4StringBuilder(List<String> strs) {
		StringBuilder strings = new StringBuilder();
		for (String str : strs) {
			strings.append(str);
			strings.append("\n");
		}
		return strings.toString();
	}
}
