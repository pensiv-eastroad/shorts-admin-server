package ai.pensiv.shorts.util;


//import java.io.Serializable;
//import java.util.Properties;
//
//public class IdGenerator implements IdentifierGenerator, Configurable {
//
//    private String prefix;
//
//    @Override
//    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//        return prefix + SecurityUtils.randomSha256Hex(32);
//    }
//
//    @Override
//    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
//        prefix = params.getProperty("prefix") != null ? params.getProperty("prefix") : "";
//    }
//}
