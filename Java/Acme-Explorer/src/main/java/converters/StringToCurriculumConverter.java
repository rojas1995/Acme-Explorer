
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Curriculum;
import repositories.CurriculumRepository;

@Component
@Transactional
public class StringToCurriculumConverter implements Converter<String, Curriculum> {

	@Autowired
	CurriculumRepository repository;

	@Override
	public Curriculum convert(final String text) {
		Curriculum result;
		int id;

		try {
			id = Integer.valueOf(text);
			result = this.repository.findOne(id);
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}