package ch.group3.bandmanagement;

import jakarta.validation.ClockProvider;
import jakarta.validation.ConstraintValidatorContext;
import org.assertj.core.util.VisibleForTesting;

/**
 * Dummy Impl of {@link jakarta.validation.ConstraintValidatorContext}.
 * This class is only visible for testing.
 */
@VisibleForTesting
public class DummyConstraintValidatorContext implements ConstraintValidatorContext {

	@Override
	public void disableDefaultConstraintViolation() {
		// No-op
	}

	@Override
	public String getDefaultConstraintMessageTemplate() {
		return "Default message template";
	}

	@Override
	public ClockProvider getClockProvider() {
		return null;
	}

	@Override
	public ConstraintViolationBuilder buildConstraintViolationWithTemplate(String messageTemplate) {
		return new DummyConstraintViolationBuilder();
	}

	@Override
	public <T> T unwrap(Class<T> type) {
		throw new UnsupportedOperationException("Unwrap not supported");
	}

	private static class DummyConstraintViolationBuilder implements ConstraintViolationBuilder {
		@Override
		public NodeBuilderDefinedContext addNode(String name) {
			return new DummyNodeBuilderDefinedContext();
		}

		@Override
		public NodeBuilderCustomizableContext addPropertyNode(String name) {
			return new DummyNodeBuilderCustomizableContext();
		}

		@Override
		public LeafNodeBuilderCustomizableContext addBeanNode() {
			return null;
		}

		@Override
		public ContainerElementNodeBuilderCustomizableContext addContainerElementNode(String name, Class<?> containerType, Integer typeArgumentIndex) {
			return null;
		}

		@Override
		public NodeBuilderDefinedContext addParameterNode(int index) {
			return null;
		}

		@Override
		public ConstraintValidatorContext addConstraintViolation() {
			return new DummyConstraintValidatorContext();
		}

		private static class DummyNodeBuilderDefinedContext implements NodeBuilderDefinedContext {
			@Override
			public NodeBuilderCustomizableContext addNode(String name) {
				return null;
			}

			@Override
			public NodeBuilderCustomizableContext addPropertyNode(String name) {
				return new DummyNodeBuilderCustomizableContext();
			}

			@Override
			public LeafNodeBuilderCustomizableContext addBeanNode() {
				return null;
			}

			@Override
			public ContainerElementNodeBuilderCustomizableContext addContainerElementNode(String name, Class<?> containerType, Integer typeArgumentIndex) {
				return null;
			}

			@Override
			public ConstraintValidatorContext addConstraintViolation() {
				return new DummyConstraintValidatorContext();
			}
		}

		private static class DummyNodeBuilderCustomizableContext implements NodeBuilderCustomizableContext {

			@Override
			public NodeContextBuilder inIterable() {
				return null;
			}

			@Override
			public NodeBuilderCustomizableContext inContainer(Class<?> containerClass, Integer typeArgumentIndex) {
				return null;
			}

			@Override
			public NodeBuilderCustomizableContext addNode(String name) {
				return null;
			}

			@Override
			public NodeBuilderCustomizableContext addPropertyNode(String name) {
				return null;
			}

			@Override
			public LeafNodeBuilderCustomizableContext addBeanNode() {
				return null;
			}

			@Override
			public ContainerElementNodeBuilderCustomizableContext addContainerElementNode(String name, Class<?> containerType, Integer typeArgumentIndex) {
				return null;
			}

			@Override
			public ConstraintValidatorContext addConstraintViolation() {
				return new DummyConstraintValidatorContext();
			}
		}
	}
}
