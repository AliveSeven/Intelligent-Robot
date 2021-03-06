package com.example.robottest;

import java.util.List;

//  接收Json数据的实体类
public class Take {
    /**
     * 调试接口数据
     * emotion : {"robotEmotion":{"a":0,"d":0,"emotionId":0,"p":0},"userEmotion":{"a":0,"d":0,"emotionId":0,"p":0}}
     * intent : {"actionName":"","code":10004,"intentName":""}
     * results : [{"groupType":0,"resultType":"text","values":{"text":"Hello"}}]
     */

//    根据接收的Json数据设置变量Bean
    private EmotionBean emotion;
    private IntentBean intent;
//    设置结果的数据Bean
    private List<ResultsBean> results;

//    自动生成get和set方法
    public EmotionBean getEmotion() {
        return emotion;
    }

    public void setEmotion(EmotionBean emotion) {
        this.emotion = emotion;
    }

    public IntentBean getIntent() {
        return intent;
    }

    public void setIntent(IntentBean intent) {
        this.intent = intent;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

//    EmotionBean里面含有robotEmotion和userEmotion的数据
    public static class EmotionBean {
        /**
         * robotEmotion : {"a":0,"d":0,"emotionId":0,"p":0}
         * userEmotion : {"a":0,"d":0,"emotionId":0,"p":0}
         */

//        根据EmotionBean里面的Json数据设置Bean变量
        private RobotEmotionBean robotEmotion;
        private UserEmotionBean userEmotion;

//        同理，一直嵌套下去
        public RobotEmotionBean getRobotEmotion() {
            return robotEmotion;
        }

        public void setRobotEmotion(RobotEmotionBean robotEmotion) {
            this.robotEmotion = robotEmotion;
        }

        public UserEmotionBean getUserEmotion() {
            return userEmotion;
        }

        public void setUserEmotion(UserEmotionBean userEmotion) {
            this.userEmotion = userEmotion;
        }

        public static class RobotEmotionBean {
            /**
             * a : 0
             * d : 0
             * emotionId : 0
             * p : 0
             */

            private int a;
            private int d;
            private int emotionId;
            private int p;

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }

            public int getD() {
                return d;
            }

            public void setD(int d) {
                this.d = d;
            }

            public int getEmotionId() {
                return emotionId;
            }

            public void setEmotionId(int emotionId) {
                this.emotionId = emotionId;
            }

            public int getP() {
                return p;
            }

            public void setP(int p) {
                this.p = p;
            }
        }

        public static class UserEmotionBean {
            /**
             * a : 0
             * d : 0
             * emotionId : 0
             * p : 0
             */

            private int a;
            private int d;
            private int emotionId;
            private int p;

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }

            public int getD() {
                return d;
            }

            public void setD(int d) {
                this.d = d;
            }

            public int getEmotionId() {
                return emotionId;
            }

            public void setEmotionId(int emotionId) {
                this.emotionId = emotionId;
            }

            public int getP() {
                return p;
            }

            public void setP(int p) {
                this.p = p;
            }
        }
    }

//    IntentBean里面含有actionName、code和intentName的数据
    public static class IntentBean {
        /**
         * actionName :
         * code : 10004
         * intentName :
         */

//        同理，根据获取的Json数据对其设置相应的变量
        private String actionName;
        private int code;
        private String intentName;

//        自动生成get和set方法
        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getIntentName() {
            return intentName;
        }

        public void setIntentName(String intentName) {
            this.intentName = intentName;
        }
    }

    public static class ResultsBean {
        /**
         * groupType : 0
         * resultType : text
         * values : {"text":"Hello"}
         */

        private int groupType;
        private String resultType;
        private ValuesBean values;

        public int getGroupType() {
            return groupType;
        }

        public void setGroupType(int groupType) {
            this.groupType = groupType;
        }

        public String getResultType() {
            return resultType;
        }

        public void setResultType(String resultType) {
            this.resultType = resultType;
        }

        public ValuesBean getValues() {
            return values;
        }

        public void setValues(ValuesBean values) {
            this.values = values;
        }

        public static class ValuesBean {
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
}
