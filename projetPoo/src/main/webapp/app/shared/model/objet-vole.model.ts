import dayjs from 'dayjs';
import { IApplicationUser } from 'app/shared/model/application-user.model';
import { IUtilisateur } from 'app/shared/model/utilisateur.model';

export interface IObjetVole {
  id?: number;
  nom?: string;
  type?: string;
  dateVole?: dayjs.Dayjs;
  cheminPhotoObjet?: string | null;
  cheminFacture?: string | null;
  etat?: string;
  adresseProprietaire?: string;
  applicationUser?: IApplicationUser | null;
  utilisateur?: IUtilisateur | null;
}

export const defaultValue: Readonly<IObjetVole> = {};
