/* $Id$ */

package com.zoho.books.util;

import com.zoho.books.exception.BooksException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * ZohoHTTPClient is used to make a HTTP request execution for GET, POST, PUT and DELETE requests.
 */

public class ZohoHTTPClient {


    /**
     * Make a GET request and fetch the response for the given URL and a query string.
     *
     * @param url      Service URL passed by the user.
     * @param queryMap This queryMap contains the query string parameters in the form of key, value pair.
     * @return Returns the JSON response String.
     */

    public static String get(String url, HashMap<String, Object> queryMap) throws Exception {
        URL urlCon = new URL(url + formQueryString(queryMap));

        HashMap<String, Object> header = new HashMap<String, Object>();

        header.put("Accept", "application/json");    //No I18N
        header.put("Content-Type", "application/x-www-form-urlencoded");    //No I18N

        HttpsURLConnection httpGet = getConnection(urlCon, "GET", header);    //No I18N

        String response = getResponse(httpGet);

        return response;
    }

    /**
     * Make a GET request and fetch the file for the given URL and a query string.
     *
     * @param url      Service URL passed by the user.
     * @param queryMap This queryMap contains the query string parameters in the form of key, value pair.
     * @return Returns the File object.
     */

    public static File getFile(String url, HashMap<String, Object> queryMap) throws Exception {
        URL urlCon = new URL(url + formQueryString(queryMap));

        HashMap<String, Object> header = new HashMap<String, Object>();

        header.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");    //No I18N
        header.put("Content-Type", "application/x-www-form-urlencoded");    //No I18N

        HttpsURLConnection httpGet = getConnection(urlCon, "GET", header);    //No I18N

        File file = getAttachment(httpGet);

        return file;
    }


    /**
     * Make a POST request and create a resource for the given URL and a request body.
     *
     * @param url         Service URL passed by the user.
     * @param requestBody This map contains the request body for the POST request.
     * @return Returns the JSON response String.
     */


    public static String post(String url, HashMap<String, Object> requestBody) throws Exception {

        URL urlCon = new URL(url);

        HashMap<String, Object> header = new HashMap<String, Object>();

        header.put("Accept", "application/json");    //No I18N
        header.put("Content-Type", "application/x-www-form-urlencoded");    //No I18N

        HttpsURLConnection httpPost = getConnection(urlCon, "POST", header);    //No I18N

        StringBuffer requestParams = new StringBuffer();

        DataOutputStream dos = new DataOutputStream(httpPost.getOutputStream());

        try {

            if (requestBody != null) {
                Iterator<String> keyIterator = requestBody.keySet().iterator();

                while (keyIterator.hasNext()) {
                    String key = keyIterator.next();
                    String value = (String) requestBody.get(key);
                    requestParams.append(URLEncoder.encode(key, "UTF-8"));            //No I18N
                    requestParams.append("=").append(URLEncoder.encode(value, "UTF-8"));    //No I18N
                    requestParams.append("&");                        //No I18N

                }

                dos.writeBytes(requestParams.toString());

            }
        } catch (Exception e) {
            throw new Exception();
        } finally {
            dos.flush();
            dos.close();
        }

        String response = getResponse(httpPost);

        return response;
    }


    /**
     * Make a POST request and create a resource for the given URL and a MultiPart form data.
     *
     * @param url         Service URL passed by the user.
     * @param queryMap    This queryMap contains the query string parameters in the form of key, value pair.
     * @param requestBody This requestBody contains the form data for the POST request.
     * @param fileBody    This fileBody contains the attachment files for the POST request.
     * @return Returns the JSON response String.
     */

    public static String post(String url, HashMap<String, Object> queryMap, HashMap<String, Object> requestBody, HashMap<String, Object> fileBody) throws Exception {

        URL urlCon = new URL(url + formQueryString(queryMap));

        String lineEnd = "\r\n";    //No I18N
        String twoHyphens = "--";    //No I18N
        String boundary = String.valueOf(System.currentTimeMillis());    //No I18N

        HashMap<String, Object> header = new HashMap<String, Object>();

        header.put("Accept", "application/json");    //No I18N
        header.put("Content-Type", "multipart/form-data; boundary=" + boundary);    //No I18N

        HttpsURLConnection httpPost = getConnection(urlCon, "POST", header);    //No I18N

        DataOutputStream dos = new DataOutputStream(httpPost.getOutputStream());

        FileInputStream fStream = null;

        try {

            if (requestBody != null) {
                Iterator<String> keyIterator = requestBody.keySet().iterator();

                while (keyIterator.hasNext()) {
                    String key = keyIterator.next();

                    dos.writeBytes(twoHyphens + boundary + lineEnd);
                    dos.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"" + lineEnd + lineEnd + requestBody.get(key).toString() + lineEnd); //No I18N


                }

            }
            if (fileBody != null) {
                Iterator<String> iterator = fileBody.keySet().iterator();

                while (iterator.hasNext()) {

                    String key = iterator.next();

                    if (fileBody.get(key) instanceof ArrayList) {

                        ArrayList<?> fileList = (ArrayList<?>) fileBody.get(key);

                        for (int i = 0; i < fileList.size(); i++) {

                            dos.writeBytes(twoHyphens + boundary + lineEnd);
                            dos.writeBytes("Content-Disposition: form-data; name=\"" + key + "\";filename=\"" + (File) fileList.get(i) + "\"" + lineEnd); //No I18N
                            dos.writeBytes(lineEnd);

                            fStream = new FileInputStream((File) fileList.get(i));
                            int bufferSize = 1024;
                            byte[] buffer = new byte[bufferSize];
                            int length = -1;

                            while ((length = fStream.read(buffer)) != -1) {
                                dos.write(buffer, 0, length);
                            }
                            dos.writeBytes(lineEnd);

                        }

                    } else if (fileBody.get(key) instanceof File) {

                        dos.writeBytes(twoHyphens + boundary + lineEnd);
                        dos.writeBytes("Content-Disposition: form-data; name=\"" + key + "\";filename=\"" + (File) fileBody.get(key) + "\"" + lineEnd); //No I18N
                        dos.writeBytes(lineEnd);
                        fStream = new FileInputStream((File) fileBody.get(key));
                        int bufferSize = 1024;
                        byte[] buffer = new byte[bufferSize];
                        int length = -1;

                        while ((length = fStream.read(buffer)) != -1) {
                            dos.write(buffer, 0, length);
                        }
                        dos.writeBytes(lineEnd);

                    }
                }
            }
            dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

        } catch (Exception e) {
            throw new Exception();
        } finally {
            if (fStream != null) {
                fStream.close();
            }
            dos.flush();
            dos.close();
        }


        String response = getResponse(httpPost);

        return response;
    }


    /**
     * Make a PUT request and update a resource for the given URL and a request body.
     *
     * @param url         Service URL passed by the user.
     * @param requestBody This requestBody contains the form data for the PUT request.
     * @return Returns the JSON response String.
     */


    public static String put(String url, HashMap<String, Object> requestBody) throws Exception {
        URL urlCon = new URL(url);

        HashMap<String, Object> header = new HashMap<String, Object>();

        header.put("Accept", "application/json");    //No I18N
        header.put("Content-Type", "application/x-www-form-urlencoded");    //No I18N

        HttpsURLConnection httpPut = getConnection(urlCon, "PUT", header);    //No I18N

        StringBuffer requestParams = new StringBuffer();

        DataOutputStream dos = new DataOutputStream(httpPut.getOutputStream());

        try {

            if (requestBody != null) {
                Iterator<String> keyIterator = requestBody.keySet().iterator();

                while (keyIterator.hasNext()) {
                    String key = keyIterator.next();
                    String value = (String) requestBody.get(key);

                    requestParams.append(URLEncoder.encode(key, "UTF-8"));            //No I18N
                    requestParams.append("=").append(URLEncoder.encode(value, "UTF-8"));    //No I18N
                    requestParams.append("&");                        //No I18N

                }

                dos.writeBytes(requestParams.toString());

            }
        } catch (Exception e) {
            throw new Exception();
        } finally {
            dos.flush();
            dos.close();
        }

        String response = getResponse(httpPut);

        return response;
    }


    /**
     * Make a PUT request and update a resource for the given URL and a MultiPart form data.
     *
     * @param url         Service URL passed by the user.
     * @param queryMap    This queryMap contains the query string parameters in the form of key, value pair.
     * @param requestBody This requestBody contains the form data for the PUT request.
     * @param fileBody    This fileBody contains the attachment files for the PUT request.
     * @return Returns the JSON response String.
     */

    public static String put(String url, HashMap<String, Object> queryMap, HashMap<String, Object> requestBody, HashMap<String, Object> fileBody) throws Exception {

        URL urlCon = new URL(url + formQueryString(queryMap));

        String lineEnd = "\r\n";    //No I18N
        String twoHyphens = "--";    //No I18N
        String boundary = String.valueOf(System.currentTimeMillis());    //No I18N

        HashMap<String, Object> header = new HashMap<String, Object>();

        header.put("Accept", "application/json");    //No I18N
        header.put("Content-Type", "multipart/form-data; boundary=" + boundary);    //No I18N

        HttpsURLConnection httpPut = getConnection(urlCon, "PUT", header);    //No I18N

        FileInputStream fStream = null;

        DataOutputStream dos = new DataOutputStream(httpPut.getOutputStream());

        try {

            if (requestBody != null) {
                Iterator<String> keyIterator = requestBody.keySet().iterator();

                while (keyIterator.hasNext()) {
                    String key = keyIterator.next();

                    dos.writeBytes(twoHyphens + boundary + lineEnd);
                    dos.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"" + lineEnd + lineEnd + requestBody.get(key).toString() + lineEnd); //No I18N
                }

            }
            if (fileBody != null) {
                Iterator<String> iterator = fileBody.keySet().iterator();

                while (iterator.hasNext()) {
                    String key = iterator.next();

                    if (fileBody.get(key) instanceof File) {

                        dos.writeBytes(twoHyphens + boundary + lineEnd);
                        dos.writeBytes("Content-Disposition: form-data; name=\"" + key + "\";filename=\"" + (File) fileBody.get(key) + "\"" + lineEnd); //No I18N
                        dos.writeBytes(lineEnd);
                        fStream = new FileInputStream((File) fileBody.get(key));
                        int bufferSize = 1024;
                        byte[] buffer = new byte[bufferSize];
                        int length = -1;

                        while ((length = fStream.read(buffer)) != -1) {
                            dos.write(buffer, 0, length);
                        }
                        dos.writeBytes(lineEnd);

                    }
                }
            }

            dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

        } catch (Exception e) {
            throw new Exception();
        } finally {
            if (fStream != null) {
                fStream.close();
            }
            dos.flush();
            dos.close();
        }

        String response = getResponse(httpPut);

        return response;
    }


    /**
     * Make a DELETE request for the given URL and a query string.
     *
     * @param url      Service URL passed by the user.
     * @param queryMap This queryMap contains the query string parameters in the form of key, value pair.
     * @return Returns the JSON response String.
     */


    public static String delete(String url, HashMap<String, Object> queryMap) throws Exception {

        URL urlCon = new URL(url + formQueryString(queryMap));

        HashMap<String, Object> header = new HashMap<String, Object>();

        header.put("Accept", "application/json");    //No I18N
        header.put("Content-Type", "application/x-www-form-urlencoded");    //No I18N

        HttpsURLConnection httpDelete = getConnection(urlCon, "DELETE", header);    //No I18N

        String response = getResponse(httpDelete);

        return response;
    }

    /**
     * Make a query string from the given queryMap.
     *
     * @param queryMap This queryMap contains the query string parameters in the form of key, value pair.
     * @return Returns the query string.
     */

    public static String formQueryString(HashMap<String, Object> queryMap) throws Exception {
        StringBuffer queryString = new StringBuffer();

        if (queryMap != null && !queryMap.isEmpty()) {

            Iterator<String> keyIterator = queryMap.keySet().iterator();

            queryString.append("?");

            while (keyIterator.hasNext()) {
                String key = keyIterator.next();
                queryString.append(key).append("=").append(queryMap.get(key).toString());
                if (keyIterator.hasNext()) {
                    queryString.append("&");
                }
            }

        }

        return queryString.toString();

    }


    /**
     * Get the response for the given HTTP request.
     *
     * @param request The request may be GET or POST or PUT or DELETE.
     * @return Returns the JSON response for the given request.
     */


    public static String getResponse(HttpsURLConnection request) throws Exception {

        int status = request.getResponseCode();

        String line = "";
        String responseLine = "";

        BufferedReader br;

        if (status == 200 || status == 201) {
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));

            while ((line = br.readLine()) != null) {
                responseLine += line;
            }

            String resp = responseLine;

            return resp;
        } else {
            br = new BufferedReader(new InputStreamReader(request.getErrorStream()));

            while ((line = br.readLine()) != null) {
                responseLine += line;
            }


            JSONObject resp = new JSONObject(responseLine.trim());

            throw new BooksException(resp.getInt("code"), resp.getString("message")); //No I18N

        }


    }


    /**
     * Get the File data for the given GET request.
     *
     * @param request The request may be GET.
     * @return Returns the File object.
     */


    public static File getAttachment(HttpsURLConnection request) throws Exception {

        int status = request.getResponseCode();

        InputStream is = request.getInputStream();
        String line = "";
        String responseLine = "";
        int inByte;

        BufferedReader br;

        if (status == 200) {

            String header = request.getHeaderField("Content-Disposition"); //No I18N

            int beginIndex = header.indexOf("\"");

            int lastIndex = header.lastIndexOf("\"");

            String fileName = header.substring(beginIndex + 1, lastIndex);

            File file = new File(fileName);

            FileOutputStream fos = new FileOutputStream(file);


            try {
                while ((inByte = is.read()) != -1) {
                    fos.write(inByte);
                }


            } catch (Exception e) {
                throw new Exception();
            } finally {
                is.close();
                fos.flush();
                fos.close();
            }

            return file;
        } else {
            br = new BufferedReader(new InputStreamReader(request.getErrorStream()));

            while ((line = br.readLine()) != null) {
                responseLine += line;
            }

            JSONObject resp = new JSONObject(responseLine.trim());

            throw new BooksException(resp.getInt("code"), resp.getString("message")); //No I18N
        }

    }

    public static HttpsURLConnection getConnection(URL url, String method, HashMap<String, Object> header) throws Exception {

        HttpsURLConnection request = (HttpsURLConnection) url.openConnection();

        request.setRequestMethod(method);
        request.setDoInput(true);
        request.setDoOutput(true);

        request.setUseCaches(false);

        request.setRequestProperty("Accept-Charset", "UTF-8");    //No I18N
        request.setRequestProperty("User-Agent", "ZohoBooks-Java-Wrappers/1.0");    //No I18N

        request.setConnectTimeout(60 * 1000);
        request.setReadTimeout(80 * 1000);

        if (header != null && !header.isEmpty()) {
            Iterator<String> keyIterator = header.keySet().iterator();

            while (keyIterator.hasNext()) {
                String key = keyIterator.next();

                request.setRequestProperty(key, header.get(key).toString());
            }

        }

        return request;


    }

}
