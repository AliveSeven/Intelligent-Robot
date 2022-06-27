package com.example.robottest;

// 创建实体类Ask，代表请求数据，使用GsonFormat工具生成请求数据实体类
public class Ask {
    /**
     * 请求数据（json格式）的例子
     * reqType : 0
     * perception : {"inputText":
     *                  {"text":"Hello"}
     *              }
     * userInfo : {"apiKey":"d9a3e3f5b2fe42489e93ee8965bb3587","userId":"756474"}
     */

    private int reqType;
    private PerceptionBean perception;
    private UserInfoBean userInfo;

    public int getReqType() {
        return reqType;
    }

    public void setReqType(int reqType) {
        this.reqType = reqType;
    }

    public PerceptionBean getPerception() {
        return perception;
    }

    public void setPerception(PerceptionBean perception) {
        this.perception = perception;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public static class PerceptionBean {
        /**
         * inputText : {"text":"Hello"}
         */

        private InputTextBean inputText;

        public InputTextBean getInputText() {
            return inputText;
        }

        public void setInputText(InputTextBean inputText) {
            this.inputText = inputText;
        }

        public static class InputTextBean {
            /**
             * text : Hello
             */

            private String text;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }

    public static class UserInfoBean {
        /**
         * 图灵机器人的apiKey和userId，这里我没有注册图灵机器人，所以直接用老师给的那个
         * apiKey : d9a3e3f5b2fe42489e93ee8965bb3587
         * userId : 756474
         */

        private String apiKey;
        private String userId;

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
