package com.microli.demo.clickevent;

public class ClickBean {

    public String name;

    public static final class ClickBeanBuilder {
        public String name;

        private ClickBeanBuilder() {
        }

        public static ClickBeanBuilder aClickBean() {
            return new ClickBeanBuilder();
        }

        public ClickBeanBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ClickBean build() {
            ClickBean clickBean = new ClickBean();
            clickBean.name = this.name;
            return clickBean;
        }
    }
}
