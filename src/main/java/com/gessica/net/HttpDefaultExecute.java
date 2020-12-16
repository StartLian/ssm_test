package com.gessica.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

public class HttpDefaultExecute {
	  public static final String GET_METHOD = "GET";

	  public static final String POST_METHOD = "POST";

	  public static final String DEFAULT_CHARSET = "utf-8";

	  private static int DEFAULT_CONNTIME = 5000;

	  private static int DEFAULT_READTIME = 20000;
	 public static String HttpDefaultExecute(String method, String path, Map<String, String> map, String data) {
		    String result = "";
		    try {
		      String url = setParmas((TreeMap<String, String>) map, path, "");
		      result = defaultConnection(method, url.replace(" ", "%20"), DEFAULT_CONNTIME, DEFAULT_READTIME, data);
		    } catch (Exception e) {
		    }
		    return result;
		  }
	 public static String defaultConnection(String method, String path, int timeout, int readTimeout, String data) throws Exception {
		    String result = "";
		    URL url = new URL(path);
		    if (url != null) {
		      HttpURLConnection conn = getConnection(method, url);
		      conn.setConnectTimeout(timeout == 0 ? DEFAULT_CONNTIME : timeout);
		      conn.setReadTimeout(readTimeout == 0 ? DEFAULT_READTIME : readTimeout);
		      if (data != null && !"".equals(data)) {
		        OutputStream output = conn.getOutputStream();
		        output.write(data.getBytes(DEFAULT_CHARSET));
		        output.flush();
		        output.close();
		      }
		      if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
		        InputStream input = conn.getInputStream();
		        result = inputToStr(input);
		        input.close();
		        conn.disconnect();
		      }
		    }
		    return result;
		  }
	  private static HttpURLConnection getConnection(String method, URL url) throws IOException {
		    HttpURLConnection conn = null;
		    if ("https".equals(url.getProtocol())) {
		      SSLContext context = null;
		      try {
		        context = SSLContext.getInstance("SSL", "SunJSSE");
		        context.init(new KeyManager[0], new TrustManager[] {new MyX509TrustManager()}, new java.security.SecureRandom());
		      } catch (Exception e) {
		        throw new IOException(e);
		      }
		      HttpsURLConnection connHttps = (HttpsURLConnection) url.openConnection();
		      connHttps.setSSLSocketFactory(context.getSocketFactory());
		      connHttps.setHostnameVerifier(new HostnameVerifier() {

		        @Override
		        public boolean verify(String arg0, SSLSession arg1) {
		          return true;
		        }
		      });
		      conn = connHttps;
		    } else {
		      conn = (HttpURLConnection) url.openConnection();
		    }
		    conn.setRequestMethod(method);
		    conn.setUseCaches(false);
		    conn.setDoInput(true);
		    conn.setDoOutput(true);
		    conn.setRequestProperty("Content-type", "application/json;charset=UTF-8");
		    return conn;
		  }
	  public static String inputToStr(InputStream is) {
		    String result = "";

		    if (is != null) {
		      StringBuilder builder = new StringBuilder();
		      BufferedReader reader = null;

		      try {
		        reader = new BufferedReader(new InputStreamReader(is, DEFAULT_CHARSET));
		        String line;
		        while ((line = reader.readLine()) != null) {
		          builder.append(line + "\n");
		        }
		      } catch (Exception e) {
		        e.printStackTrace();
		      } finally {
		        try {
		          reader.close();
		        } catch (IOException e) {
		          e.printStackTrace();
		        }
		      }
		      return builder.toString();

		    }
		    return result;
		  }
	  public static String setParmas(Map<String, String> map, String path, String charset) throws Exception {
		    String result = "";
		    boolean hasParams = false;
		    if (path != null && !"".equals(path)) {
		      if (map != null && map.size() > 0) {
		        StringBuilder builder = new StringBuilder();
		        Set<Entry<String, String>> params = map.entrySet();
		        for (Entry<String, String> entry : params) {
		          String key = entry.getKey().trim();
		          String value = entry.getValue().trim();
		          if (hasParams) {
		            builder.append("&");
		          } else {
		            hasParams = true;
		          }
		          if (charset != null && !"".equals(charset)) {
		            //builder.append(key).append("=").append(URLDecoder.(value, charset));
		            builder.append(key).append("=").append(urlEncode(value, charset));
		          } else {
		            builder.append(key).append("=").append(value);
		          }
		        }
		        result = builder.toString();
		      }
		    }
		    return doUrlPath(path, result).toString();
		  }
	  private static URL doUrlPath(String path, String query) throws Exception {
		    URL url = new URL(path);
		    if (org.apache.commons.lang.StringUtils.isEmpty(path)) {
		      return url;
		    }
		    if (org.apache.commons.lang.StringUtils.isEmpty(url.getQuery())) {
		      if (path.endsWith("?")) {
		        path += query;
		      } else {
		        path = path + "?" + query;
		      }
		    } else {
		      if (path.endsWith("&")) {
		        path += query;
		      } else {
		        path = path + "&" + query;
		      }
		    }
		    return new URL(path);
		  }
	  public static String urlEncode(String source, String encode) {
		    String result = source;
		    try {
		      result = URLEncoder.encode(source, encode);
		    } catch (UnsupportedEncodingException e) {
		      e.printStackTrace();
		    }
		    return result;
		  }
}
