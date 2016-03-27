package com.vshuok.es.common.plugin.entity;

/**
 * <p>
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
public interface Stateable<T extends Enum<? extends Stateable.Status>> {

	public void setStatus(T status);

	public T getStatus();

	/**
	 * 标识接口，所有状态实现，需要实现该状态接口
	 * 
	 * @author David
	 *
	 */
	public static interface Status {
	}

	/**
	 * 审核状态
	 * 
	 * @author David
	 *
	 */
	public static enum AuditStatus implements Status {
		waiting("等待审核"), fail("审核失败"), success("审核成功");
		private final String info;

		private AuditStatus(String info) {
			this.info = info;
		}

		public String getInfo() {
			return info;
		}

		/**
		 * 是否显示
		 * @author David
		 *
		 */
		public static enum ShowStatus implements Status {
			hide("不显示"), show("显示");
			private final String info;

			private ShowStatus(String info) {
				this.info = info;
			}

			public String getInfo() {
				return info;
			}
		}
	}
}
