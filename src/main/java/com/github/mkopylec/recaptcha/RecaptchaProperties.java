package com.github.mkopylec.recaptcha;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

import static java.util.Collections.singletonList;

@ConfigurationProperties("spring.recaptcha")
public class RecaptchaProperties {

    private Validation validation = new Validation();
    private Security security = new Security();

    public Validation getValidation() {
        return validation;
    }

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public static class Validation {

        private String secretKey;
        private String responseParameter = "g-recaptcha-response";
        private String verificationUrl = "https://www.google.com/recaptcha/api/siteverify";

        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }

        public String getResponseParameter() {
            return responseParameter;
        }

        public void setResponseParameter(String responseParameter) {
            this.responseParameter = responseParameter;
        }

        public String getVerificationUrl() {
            return verificationUrl;
        }

        public void setVerificationUrl(String verificationUrl) {
            this.verificationUrl = verificationUrl;
        }
    }

    public static class Security {

        private String failureUrl = "/login?recaptchaError";
        private List<String> securedPaths = singletonList("/login");

        public String getFailureUrl() {
            return failureUrl;
        }

        public void setFailureUrl(String failureUrl) {
            this.failureUrl = failureUrl;
        }

        public List<String> getSecuredPaths() {
            return securedPaths;
        }

        public void setSecuredPaths(List<String> securedPaths) {
            this.securedPaths = securedPaths;
        }
    }
}
