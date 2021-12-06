package com.tlu.cardexchange.util;

import org.springframework.stereotype.Component;

@Component
public class ErrorCodeUtil {
  public String getMessageFromCode(Integer code) {
    StringBuilder result = new StringBuilder();
    switch (code) {
      case -4:
        result.append("Mã giao dịch đã tồn tại");
        break;
      case -3:
        result.append("Sai dữ liệu đầu vào");
        break;
      case -2:
        result.append("Bị khóa do nghi vấn dò quét hệ thống. Vui lòng thực hiện lại sau 30p");
        break;
      case -1:
        result.append("Hệ thống đang bận hoặc bị khóa tạm thời việc nạp thẻ, thực hiện lại giao dịch sau 1 lúc");
        break;
      case 1:
        result.append("Nạp thành công");
        break;
      case 2:
        result.append("Thẻ sai mệnh giá (sẽ nạp 50% giá trị thẻ thật vào tài khoản)");
        break;
      case 3:
        result.append("Thẻ lỗi");
        break;
      case 307:
        result.append("Thẻ đã tồn tại trong hệ thống");
        break;
      case 311:
        result.append("Thẻ sai định dạng");
        break;
      case 99:
        result.append("Chờ xử lý");
        break;
      case -99:
        result.append("Chờ xử lý");
        break;
      default:
        result.append("NA");
    }
    return result.toString();
  }
}
