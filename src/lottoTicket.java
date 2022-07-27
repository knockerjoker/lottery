import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lottoTicket {
    private static int lottoTicketSize = 6;
    private  final List<Long> lottoNumbers;

    public lottoTicket(List<Long> lottoNumbers) {
        rightSize(lottoNumbers);
        noDuplicates(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }
    public void rightSize(List<Long> lottoNumbers){
        if(lottoNumbers.size() != lottoTicketSize){
            throw new IllegalArgumentException("한 줄에 6개만 쓸 수 있어용");
        }
    }
    public void noDuplicates(List<Long> lottoNumbers){
        Set<Long> tmp = new HashSet<>(lottoNumbers);
        if (tmp.size() != lottoTicketSize){
            throw new IllegalArgumentException("숫자는 중복될 수 없어용");
        }
    }
}
