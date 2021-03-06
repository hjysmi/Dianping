package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.a.a.c;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a.b;
import com.tencent.tauth.IRequestListener;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpUtils
{
  private static final String a = HttpUtils.class.getName();

  private static int a(Context paramContext)
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11)
      if (paramContext != null)
      {
        int j = Proxy.getPort(paramContext);
        i = j;
        if (j < 0)
          i = Proxy.getDefaultPort();
      }
    do
    {
      return i;
      return Proxy.getDefaultPort();
      paramContext = System.getProperty("http.proxyPort");
    }
    while (TextUtils.isEmpty(paramContext));
    try
    {
      i = Integer.parseInt(paramContext);
      return i;
    }
    catch (java.lang.NumberFormatException paramContext)
    {
    }
    return -1;
  }

  private static int a(IOException paramIOException)
  {
    if ((paramIOException instanceof CharConversionException))
      return -20;
    if ((paramIOException instanceof MalformedInputException))
      return -21;
    if ((paramIOException instanceof UnmappableCharacterException))
      return -22;
    if ((paramIOException instanceof HttpResponseException))
      return -23;
    if ((paramIOException instanceof ClosedChannelException))
      return -24;
    if ((paramIOException instanceof ConnectionClosedException))
      return -25;
    if ((paramIOException instanceof EOFException))
      return -26;
    if ((paramIOException instanceof FileLockInterruptionException))
      return -27;
    if ((paramIOException instanceof FileNotFoundException))
      return -28;
    if ((paramIOException instanceof HttpRetryException))
      return -29;
    if ((paramIOException instanceof ConnectTimeoutException))
      return -7;
    if ((paramIOException instanceof SocketTimeoutException))
      return -8;
    if ((paramIOException instanceof InvalidPropertiesFormatException))
      return -30;
    if ((paramIOException instanceof MalformedChunkCodingException))
      return -31;
    if ((paramIOException instanceof MalformedURLException))
      return -3;
    if ((paramIOException instanceof NoHttpResponseException))
      return -32;
    if ((paramIOException instanceof InvalidClassException))
      return -33;
    if ((paramIOException instanceof InvalidObjectException))
      return -34;
    if ((paramIOException instanceof NotActiveException))
      return -35;
    if ((paramIOException instanceof NotSerializableException))
      return -36;
    if ((paramIOException instanceof OptionalDataException))
      return -37;
    if ((paramIOException instanceof StreamCorruptedException))
      return -38;
    if ((paramIOException instanceof WriteAbortedException))
      return -39;
    if ((paramIOException instanceof ProtocolException))
      return -40;
    if ((paramIOException instanceof SSLHandshakeException))
      return -41;
    if ((paramIOException instanceof SSLKeyException))
      return -42;
    if ((paramIOException instanceof SSLPeerUnverifiedException))
      return -43;
    if ((paramIOException instanceof SSLProtocolException))
      return -44;
    if ((paramIOException instanceof BindException))
      return -45;
    if ((paramIOException instanceof ConnectException))
      return -46;
    if ((paramIOException instanceof NoRouteToHostException))
      return -47;
    if ((paramIOException instanceof PortUnreachableException))
      return -48;
    if ((paramIOException instanceof SyncFailedException))
      return -49;
    if ((paramIOException instanceof UTFDataFormatException))
      return -50;
    if ((paramIOException instanceof UnknownHostException))
      return -51;
    if ((paramIOException instanceof UnknownServiceException))
      return -52;
    if ((paramIOException instanceof UnsupportedEncodingException))
      return -53;
    if ((paramIOException instanceof ZipException))
      return -54;
    return -2;
  }

  private static String a(HttpResponse paramHttpResponse)
    throws IllegalStateException, IOException
  {
    Object localObject = paramHttpResponse.getEntity().getContent();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Encoding");
    if ((paramHttpResponse != null) && (paramHttpResponse.getValue().toLowerCase().indexOf("gzip") > -1));
    for (paramHttpResponse = new GZIPInputStream((InputStream)localObject); ; paramHttpResponse = (HttpResponse)localObject)
    {
      localObject = new byte[512];
      while (true)
      {
        int i = paramHttpResponse.read(localObject);
        if (i == -1)
          break;
        localByteArrayOutputStream.write(localObject, 0, i);
      }
      return new String(localByteArrayOutputStream.toByteArray());
    }
  }

  private static void a(Context paramContext, QQToken paramQQToken, String paramString)
  {
    if ((paramString.indexOf("add_share") > -1) || (paramString.indexOf("upload_pic") > -1) || (paramString.indexOf("add_topic") > -1) || (paramString.indexOf("set_user_face") > -1) || (paramString.indexOf("add_t") > -1) || (paramString.indexOf("add_pic_t") > -1) || (paramString.indexOf("add_pic_url") > -1) || (paramString.indexOf("add_video") > -1))
      a.a(paramContext, paramQQToken, "requireApi", new String[] { paramString });
  }

  private static String b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (paramContext != null)
      {
        String str = Proxy.getHost(paramContext);
        paramContext = str;
        if (TextUtils.isEmpty(str))
          paramContext = Proxy.getDefaultHost();
        return paramContext;
      }
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }

  public static String encodePostBody(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramBundle.size();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      i += 1;
      Object localObject = paramBundle.get(str);
      if (!(localObject instanceof String))
        continue;
      localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"" + "\r\n" + "\r\n" + (String)localObject);
      if (i < j - 1)
        localStringBuilder.append("\r\n--" + paramString + "\r\n");
    }
    return localStringBuilder.toString();
  }

  public static String encodeUrl(Bundle paramBundle)
  {
    if (paramBundle == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramBundle.get((String)localObject1);
      if ((!(localObject2 instanceof String)) && (!(localObject2 instanceof String[])))
        continue;
      if ((localObject2 instanceof String[]))
      {
        int j;
        if (i != 0)
        {
          i = 0;
          localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=");
          localObject1 = (String[])paramBundle.getStringArray((String)localObject1);
          j = 0;
          label126: if (j >= localObject1.length)
            break label204;
          if (j != 0)
            break label170;
          localStringBuilder.append(URLEncoder.encode(localObject1[j]));
        }
        while (true)
        {
          j += 1;
          break label126;
          localStringBuilder.append("&");
          break;
          label170: localStringBuilder.append(URLEncoder.encode("," + localObject1[j]));
        }
        label204: continue;
      }
      if (i != 0)
        i = 0;
      while (true)
      {
        localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=" + URLEncoder.encode(paramBundle.getString((String)localObject1)));
        break;
        localStringBuilder.append("&");
      }
    }
    return (String)localStringBuilder.toString();
  }

  public static HttpClient getHttpClient(Context paramContext, String paramString1, String paramString2)
  {
    int i = 0;
    paramString2 = new SchemeRegistry();
    paramString2.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    if (Build.VERSION.SDK_INT < 16);
    while (true)
    {
      try
      {
        Object localObject = KeyStore.getInstance(KeyStore.getDefaultType());
        ((KeyStore)localObject).load(null, null);
        localObject = new CustomSSLSocketFactory((KeyStore)localObject);
        ((org.apache.http.conn.ssl.SSLSocketFactory)localObject).setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        paramString2.register(new Scheme("https", (SocketFactory)localObject, 443));
        localObject = new BasicHttpParams();
        if (paramContext == null)
          break label347;
        paramString1 = OpenConfig.getInstance(paramContext, paramString1);
        if (paramString1 == null)
          break label341;
        j = paramString1.getInt("Common_HttpConnectionTimeout");
        i = paramString1.getInt("Common_SocketConnectionTimeout");
        int k = j;
        if (j != 0)
          continue;
        k = 15000;
        j = i;
        if (i != 0)
          continue;
        j = 30000;
        HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, k);
        HttpConnectionParams.setSoTimeout((HttpParams)localObject, j);
        HttpProtocolParams.setVersion((HttpParams)localObject, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset((HttpParams)localObject, "UTF-8");
        HttpProtocolParams.setUserAgent((HttpParams)localObject, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        paramString1 = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject, paramString2), (HttpParams)localObject);
        paramContext = getProxy(paramContext);
        if (paramContext == null)
          continue;
        paramContext = new HttpHost(paramContext.host, paramContext.port);
        paramString1.getParams().setParameter("http.route.default-proxy", paramContext);
        return paramString1;
      }
      catch (Exception localException)
      {
        paramString2.register(new Scheme("https", org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory(), 443));
        continue;
      }
      paramString2.register(new Scheme("https", org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory(), 443));
      continue;
      label341: int j = 0;
      continue;
      label347: paramString1 = null;
    }
  }

  public static NetworkProxy getProxy(Context paramContext)
  {
    if (paramContext == null)
      return null;
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null)
      return null;
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
      return null;
    if (((NetworkInfo)localObject).getType() == 0)
    {
      localObject = b(paramContext);
      int i = a(paramContext);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (i >= 0))
        return new NetworkProxy((String)localObject, i, null);
    }
    return (NetworkProxy)null;
  }

  public static Util.Statistic openUrl2(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws MalformedURLException, IOException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException
  {
    Object localObject1;
    if (paramContext != null)
    {
      localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject1 != null)
      {
        localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if ((localObject1 == null) || (!((NetworkInfo)localObject1).isAvailable()))
          throw new NetworkUnavailableException("network unavailable");
      }
    }
    int i;
    if (paramBundle != null)
    {
      paramBundle = new Bundle(paramBundle);
      localObject1 = paramBundle.getString("appid_for_getting_config");
      paramBundle.remove("appid_for_getting_config");
      localObject1 = getHttpClient(paramContext, (String)localObject1, paramString1);
      if (!paramString2.equals("GET"))
        break label327;
      paramString2 = encodeUrl(paramBundle);
      i = paramString2.length();
      c.b(a, "-->openUrl2 before url =" + paramString1);
      if (paramString1.indexOf("?") != -1)
        break label303;
      paramContext = paramString1 + "?";
      label169: c.b(a, "-->openUrl2 encodedParam =" + paramString2 + " -- url = " + paramContext);
      paramContext = new HttpGet(paramContext + paramString2);
      paramContext.addHeader("Accept-Encoding", "gzip");
      i = 0 + i;
    }
    while (true)
    {
      paramContext = ((HttpClient)localObject1).execute(paramContext);
      int j = paramContext.getStatusLine().getStatusCode();
      if (j == 200)
      {
        return new Util.Statistic(a(paramContext), i);
        paramBundle = new Bundle();
        break;
        label303: paramContext = paramString1 + "&";
        break label169;
        label327: if (paramString2.equals("POST"))
        {
          paramContext = new HttpPost(paramString1);
          paramContext.addHeader("Accept-Encoding", "gzip");
          paramString1 = new Bundle();
          Object localObject2 = paramBundle.keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            Object localObject3 = paramBundle.get(str);
            if (!(localObject3 instanceof byte[]))
              continue;
            paramString1.putByteArray(str, (byte[])(byte[])localObject3);
          }
          if (!paramBundle.containsKey("method"))
            paramBundle.putString("method", paramString2);
          paramContext.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
          paramContext.setHeader("Connection", "Keep-Alive");
          paramString2 = new ByteArrayOutputStream();
          paramString2.write("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes());
          paramString2.write(encodePostBody(paramBundle, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
          if (!paramString1.isEmpty())
          {
            int k = paramString1.size();
            paramString2.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes());
            paramBundle = paramString1.keySet().iterator();
            i = -1;
            while (paramBundle.hasNext())
            {
              localObject2 = (String)paramBundle.next();
              j = i + 1;
              paramString2.write(("Content-Disposition: form-data; name=\"" + (String)localObject2 + "\"; filename=\"" + (String)localObject2 + "\"" + "\r\n").getBytes());
              paramString2.write("Content-Type: content/unknown\r\n\r\n".getBytes());
              localObject2 = paramString1.getByteArray((String)localObject2);
              if (localObject2 != null)
                paramString2.write(localObject2);
              i = j;
              if (j >= k - 1)
                continue;
              paramString2.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes());
              i = j;
            }
          }
          paramString2.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n".getBytes());
          paramString1 = paramString2.toByteArray();
          i = paramString1.length + 0;
          paramString2.close();
          paramContext.setEntity(new ByteArrayEntity(paramString1));
          continue;
        }
      }
      else
      {
        throw new HttpStatusException("http status code error:" + j);
      }
      paramContext = null;
      i = 0;
    }
  }

  public static JSONObject request(QQToken paramQQToken, Context paramContext, String paramString1, Bundle paramBundle, String paramString2)
    throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException
  {
    c.a("openSDK_LOG", "OpenApi request");
    String str4;
    String str3;
    if (!paramString1.toLowerCase().startsWith("http"))
    {
      str4 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString1;
      str3 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString1;
    }
    while (true)
    {
      a(paramContext, paramQQToken, paramString1);
      paramString1 = null;
      long l2 = SystemClock.elapsedRealtime();
      int k = 0;
      int i = OpenConfig.getInstance(paramContext, paramQQToken.getAppId()).getInt("Common_HttpRetryCount");
      Log.d("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + i + "   appid:" + paramQQToken.getAppId() + "     url:" + str3);
      int j = i;
      if (i == 0)
        j = 3;
      Log.d("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + j + "   appid:" + paramQQToken.getAppId() + "     url:" + str3);
      while (true)
      {
        int m = k + 1;
        try
        {
          Util.Statistic localStatistic = openUrl2(paramContext, str4, paramString2, paramBundle);
          JSONObject localJSONObject = Util.parseJson(localStatistic.response);
          paramString1 = localJSONObject;
          try
          {
            i = paramString1.getInt("ret");
            l3 = localStatistic.reqSize;
            l4 = localStatistic.rspSize;
            l1 = l2;
            b.a().a(paramContext, str3, l1, l3, l4, i, paramQQToken.getAppId());
            return paramString1;
          }
          catch (JSONException localJSONException)
          {
            while (true)
              i = -4;
          }
          catch (ConnectTimeoutException str1)
          {
            String str1;
            while (true)
            {
              localConnectTimeoutException1.printStackTrace();
              if (m >= j)
                break label373;
              l1 = SystemClock.elapsedRealtime();
              i = -7;
              str1 = paramString1;
              long l4 = 0L;
              k = m;
              l2 = l1;
              paramString1 = str1;
              if (m < j)
                break;
              paramString1 = str1;
              long l3 = 0L;
            }
            b.a().a(paramContext, str3, l2, 0L, 0L, -7, paramQQToken.getAppId());
            throw str1;
          }
          catch (SocketTimeoutException str2)
          {
            label319: label373: String str2;
            while (true)
            {
              label397: localSocketTimeoutException1.printStackTrace();
              if (m >= j)
                break;
              long l1 = SystemClock.elapsedRealtime();
              i = -8;
              str2 = paramString1;
            }
            b.a().a(paramContext, str3, l2, 0L, 0L, -8, paramQQToken.getAppId());
            throw str2;
          }
        }
        catch (HttpStatusException paramString1)
        {
          paramString1.printStackTrace();
          paramBundle = paramString1.getMessage();
          try
          {
            i = Integer.parseInt(paramBundle.replace("http status code error:", ""));
            b.a().a(paramContext, str3, l2, 0L, 0L, i, paramQQToken.getAppId());
            throw paramString1;
          }
          catch (Exception paramBundle)
          {
            while (true)
            {
              paramBundle.printStackTrace();
              i = -9;
            }
          }
        }
        catch (NetworkUnavailableException paramQQToken)
        {
          paramQQToken.printStackTrace();
          throw paramQQToken;
        }
        catch (MalformedURLException paramString1)
        {
          paramString1.printStackTrace();
          b.a().a(paramContext, str3, l2, 0L, 0L, -3, paramQQToken.getAppId());
          throw paramString1;
        }
        catch (IOException paramString1)
        {
          paramString1.printStackTrace();
          i = a(paramString1);
          b.a().a(paramContext, str3, l2, 0L, 0L, i, paramQQToken.getAppId());
          throw paramString1;
        }
        catch (JSONException paramString1)
        {
          paramString1.printStackTrace();
          b.a().a(paramContext, str3, l2, 0L, 0L, -4, paramQQToken.getAppId());
          throw paramString1;
        }
        catch (SocketTimeoutException localSocketTimeoutException2)
        {
          break label397;
        }
        catch (ConnectTimeoutException localConnectTimeoutException2)
        {
          break label319;
        }
      }
      str3 = paramString1;
      str4 = paramString1;
    }
  }

  public static void requestAsync(QQToken paramQQToken, Context paramContext, String paramString1, Bundle paramBundle, String paramString2, IRequestListener paramIRequestListener)
  {
    c.a("openSDK_LOG", "OpenApi requestAsync");
    new Thread(paramQQToken, paramContext, paramString1, paramBundle, paramString2, paramIRequestListener)
    {
      public void run()
      {
        try
        {
          JSONObject localJSONObject = HttpUtils.request(this.a, this.b, this.c, this.d, this.e);
          if (this.f != null)
          {
            this.f.onComplete(localJSONObject);
            c.b("openSDK_LOG", "OpenApi onComplete");
          }
          return;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          while (this.f == null);
          this.f.onMalformedURLException(localMalformedURLException);
          c.a("openSDK_LOG", "OpenApi requestAsync MalformedURLException", localMalformedURLException);
          return;
        }
        catch (ConnectTimeoutException localConnectTimeoutException)
        {
          while (this.f == null);
          this.f.onConnectTimeoutException(localConnectTimeoutException);
          c.a("openSDK_LOG", "OpenApi requestAsync onConnectTimeoutException", localConnectTimeoutException);
          return;
        }
        catch (SocketTimeoutException localSocketTimeoutException)
        {
          while (this.f == null);
          this.f.onSocketTimeoutException(localSocketTimeoutException);
          c.a("openSDK_LOG", "OpenApi requestAsync onSocketTimeoutException", localSocketTimeoutException);
          return;
        }
        catch (HttpUtils.NetworkUnavailableException localNetworkUnavailableException)
        {
          while (this.f == null);
          this.f.onNetworkUnavailableException(localNetworkUnavailableException);
          c.a("openSDK_LOG", "OpenApi requestAsync onNetworkUnavailableException", localNetworkUnavailableException);
          return;
        }
        catch (HttpUtils.HttpStatusException localHttpStatusException)
        {
          while (this.f == null);
          this.f.onHttpStatusException(localHttpStatusException);
          c.a("openSDK_LOG", "OpenApi requestAsync onHttpStatusException", localHttpStatusException);
          return;
        }
        catch (IOException localIOException)
        {
          while (this.f == null);
          this.f.onIOException(localIOException);
          c.a("openSDK_LOG", "OpenApi requestAsync IOException", localIOException);
          return;
        }
        catch (JSONException localJSONException)
        {
          while (this.f == null);
          this.f.onJSONException(localJSONException);
          c.a("openSDK_LOG", "OpenApi requestAsync JSONException", localJSONException);
          return;
        }
        catch (Exception localException)
        {
          while (this.f == null);
          this.f.onUnknowException(localException);
          c.a("openSDK_LOG", "OpenApi requestAsync onUnknowException", localException);
        }
      }
    }
    .start();
  }

  public static JSONObject upload(QQToken paramQQToken, Context paramContext, String paramString, Bundle paramBundle)
    throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException
  {
    String str4;
    String str3;
    if (!paramString.toLowerCase().startsWith("http"))
    {
      str4 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString;
      str3 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString;
    }
    while (true)
    {
      a(paramContext, paramQQToken, paramString);
      paramString = null;
      long l2 = SystemClock.elapsedRealtime();
      int k = 0;
      int i = OpenConfig.getInstance(paramContext, paramQQToken.getAppId()).getInt("Common_HttpRetryCount");
      Log.d("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + i + "   appid:" + paramQQToken.getAppId() + "     url:" + str3);
      int j = i;
      if (i == 0)
        j = 3;
      Log.d("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + j + "   appid:" + paramQQToken.getAppId() + "     url:" + str3);
      while (true)
      {
        int m = k + 1;
        try
        {
          Util.Statistic localStatistic = Util.upload(paramContext, str4, paramBundle);
          JSONObject localJSONObject = Util.parseJson(localStatistic.response);
          paramString = localJSONObject;
          try
          {
            i = paramString.getInt("ret");
            l3 = localStatistic.reqSize;
            l4 = localStatistic.rspSize;
            l1 = l2;
            b.a().a(paramContext, str3, l1, l3, l4, i, paramQQToken.getAppId());
            return paramString;
          }
          catch (JSONException localJSONException)
          {
            while (true)
              i = -4;
          }
          catch (ConnectTimeoutException str1)
          {
            String str1;
            while (true)
            {
              localConnectTimeoutException1.printStackTrace();
              if (m >= j)
                break label362;
              l1 = SystemClock.elapsedRealtime();
              i = -7;
              str1 = paramString;
              long l4 = 0L;
              k = m;
              l2 = l1;
              paramString = str1;
              if (m < j)
                break;
              paramString = str1;
              long l3 = 0L;
            }
            b.a().a(paramContext, str3, l2, 0L, 0L, -7, paramQQToken.getAppId());
            throw str1;
          }
          catch (SocketTimeoutException str2)
          {
            label308: label362: String str2;
            while (true)
            {
              label386: localSocketTimeoutException1.printStackTrace();
              if (m >= j)
                break;
              long l1 = SystemClock.elapsedRealtime();
              i = -8;
              str2 = paramString;
            }
            b.a().a(paramContext, str3, l2, 0L, 0L, -8, paramQQToken.getAppId());
            throw str2;
          }
        }
        catch (HttpStatusException paramString)
        {
          paramString.printStackTrace();
          paramBundle = paramString.getMessage();
          try
          {
            i = Integer.parseInt(paramBundle.replace("http status code error:", ""));
            b.a().a(paramContext, str3, l2, 0L, 0L, i, paramQQToken.getAppId());
            throw paramString;
          }
          catch (Exception paramBundle)
          {
            while (true)
            {
              paramBundle.printStackTrace();
              i = -9;
            }
          }
        }
        catch (NetworkUnavailableException paramQQToken)
        {
          paramQQToken.printStackTrace();
          throw paramQQToken;
        }
        catch (MalformedURLException paramString)
        {
          paramString.printStackTrace();
          b.a().a(paramContext, str3, l2, 0L, 0L, -3, paramQQToken.getAppId());
          throw paramString;
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          i = a(paramString);
          b.a().a(paramContext, str3, l2, 0L, 0L, i, paramQQToken.getAppId());
          throw paramString;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          b.a().a(paramContext, str3, l2, 0L, 0L, -4, paramQQToken.getAppId());
          throw paramString;
        }
        catch (SocketTimeoutException localSocketTimeoutException2)
        {
          break label386;
        }
        catch (ConnectTimeoutException localConnectTimeoutException2)
        {
          break label308;
        }
      }
      str3 = paramString;
      str4 = paramString;
    }
  }

  public static class CustomSSLSocketFactory extends org.apache.http.conn.ssl.SSLSocketFactory
  {
    private SSLContext a = SSLContext.getInstance("TLS");

    public CustomSSLSocketFactory(KeyStore paramKeyStore)
      throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
      super();
      try
      {
        paramKeyStore = new HttpUtils.MyX509TrustManager();
        this.a.init(null, new TrustManager[] { paramKeyStore }, null);
        return;
      }
      catch (Exception paramKeyStore)
      {
        while (true)
          paramKeyStore = null;
      }
    }

    public Socket createSocket()
      throws IOException
    {
      return this.a.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
      throws IOException, UnknownHostException
    {
      return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    }
  }

  public static class HttpStatusException extends Exception
  {
    public static final String ERROR_INFO = "http status code error:";

    public HttpStatusException(String paramString)
    {
      super();
    }
  }

  public static class MyX509TrustManager
    implements X509TrustManager
  {
    X509TrustManager a;

    MyX509TrustManager()
      throws Exception
    {
      try
      {
        Object localObject1 = KeyStore.getInstance("JKS");
        if (localObject1 != null)
        {
          ((KeyStore)localObject1).load(new FileInputStream("trustedCerts"), "passphrase".toCharArray());
          TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
          localTrustManagerFactory.init((KeyStore)localObject1);
          localObject1 = localTrustManagerFactory.getTrustManagers();
          i = 0;
          if (i >= localObject1.length)
            break label114;
          if (!(localObject1[i] instanceof X509TrustManager))
            break label107;
          this.a = ((X509TrustManager)localObject1[i]);
          return;
        }
      }
      catch (Exception localObject2)
      {
        while (true)
        {
          int i;
          Object localObject2 = null;
          continue;
          localObject2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
          ((TrustManagerFactory)localObject2).init((KeyStore)null);
          localObject2 = ((TrustManagerFactory)localObject2).getTrustManagers();
          continue;
          label107: i += 1;
        }
      }
      label114: throw new Exception("Couldn't initialize");
    }

    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      try
      {
        this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
        return;
      }
      catch (CertificateException paramArrayOfX509Certificate)
      {
      }
    }

    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      try
      {
        this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
        return;
      }
      catch (CertificateException paramArrayOfX509Certificate)
      {
      }
    }

    public X509Certificate[] getAcceptedIssuers()
    {
      return this.a.getAcceptedIssuers();
    }
  }

  public static class NetworkProxy
  {
    public final String host;
    public final int port;

    private NetworkProxy(String paramString, int paramInt)
    {
      this.host = paramString;
      this.port = paramInt;
    }
  }

  public static class NetworkUnavailableException extends Exception
  {
    public static final String ERROR_INFO = "network unavailable";

    public NetworkUnavailableException(String paramString)
    {
      super();
    }
  }
}

/* Location:           C:\Users\xuetong\Desktop\dazhongdianping7.9.6\ProjectSrc\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.HttpUtils
 * JD-Core Version:    0.6.0
 */