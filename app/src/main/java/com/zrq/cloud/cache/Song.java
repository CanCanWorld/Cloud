package com.zrq.cloud.cache;

import java.util.List;

public class Song {

    private Integer code;
    private DataDTO data;
    private String message;

    public static class DataDTO {
        private Integer total;
        private List<ListDTO> list;

        public static class ListDTO {
            private String resourceId;
            private Long playTime;
            private String resourceType;

            public static class DataDTO {
                private String name;
                private Integer id;
                private Integer pst;
                private Integer t;
                private List<DataDTO.ListDTO.DataDTO.ArDTO> ar;
                private List<?> alia;
                private Integer pop;
                private Integer st;
                private String rt;
                private Integer fee;
                private Integer v;
                private Object crbt;
                private String cf;
                private DataDTO.ListDTO.DataDTO.AlDTO al;
                private Integer dt;
                private DataDTO.ListDTO.DataDTO.HDTO h;
                private DataDTO.ListDTO.DataDTO.MDTO m;
                private DataDTO.ListDTO.DataDTO.LDTO l;
                private Object a;
                private String cd;
                private Integer no;
                private Object rtUrl;
                private Integer ftype;
                private List<?> rtUrls;
                private Integer djId;
                private Integer copyright;
                private Integer sId;
                private Integer mark;
                private Integer originCoverType;
                private Object originSongSimpleData;
                private Integer single;
                private Object noCopyrightRcmd;
                private Integer rtype;
                private Object rurl;
                private Integer mst;
                private Integer cp;
                private Integer mv;
                private Long publishTime;

                public static class AlDTO {
                    private Integer id;
                    private String name;
                    private String picUrl;
                    private List<?> tns;
                    private String picStr;
                    private Long pic;
                }

                public static class HDTO {
                    private Integer br;
                    private Integer fid;
                    private Integer size;
                    private Integer vd;
                }

                public static class MDTO {
                    private Integer br;
                    private Integer fid;
                    private Integer size;
                    private Integer vd;
                }

                public static class LDTO {
                    private Integer br;
                    private Integer fid;
                    private Integer size;
                    private Integer vd;
                }

                public static class ArDTO {
                    private Integer id;
                    private String name;
                    private List<?> tns;
                    private List<?> alias;
                }
            }
        }
    }
}
