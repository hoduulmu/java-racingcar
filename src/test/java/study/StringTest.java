package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	/**
	 * 요구사항 1
	 */
	@Test
	void split() {
		String[] result = "1,2".split(",");

		assertThat(result).containsExactly("1", "2");

		result = "1".split(",");

		assertThat(result).containsExactly("1");
	}

	/**
	 * 요구사항 2
	 */
	@Test
	void substring() {
		String result = "(1,2)".substring(1,4);

		assertThat(result).isEqualTo("1,2");
	}

	/**
	 * 요구사항 3-1
	 */
	@Test
	@DisplayName("abc 문자열이 있을때 index 1 번째 위치의 문자는 b")
	void charAt() {
		char result = "abc".charAt(1);

		assertThat(result).isEqualTo('b');
	}

	/**
	 * 요구사항 3-2
	 */
	@Test
	@DisplayName("abc 문자열이 있을때 index 6 번째 위치의 문자를 가져오면 IndexOutOfBoundsException 발생")
	void stringIndexOutOfBoundsException() {
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				char result = "abc".charAt(6);
			}).withMessageMatching("String index out of range: \\d+");
	}
}
